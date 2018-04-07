package com.baeldung.spring.dao.impl;


import java.util.Date;
import java.util.List;

import com.baeldung.spring.dao.FeedbackDao;
import com.baeldung.spring.entity.data.CfsFeedback;
import com.baeldung.spring.entity.data.CfsTopic;
import com.baeldung.spring.entity.form.FeedbackForm;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // get all feedbacks by topic id
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public List<CfsFeedback> getAllFeedbacks(Integer topicId) {
        Session session = this.sessionFactory.getCurrentSession();
        // Create criteria : Feedback : add like topic.id topicid
        Criteria crit = session.createCriteria(CfsFeedback.class);
        crit.add(Restrictions.like("cfsTopic.id",topicId));
        List<CfsFeedback> feedbacks = crit.list();// return
        return feedbacks;

    }

    // add feedback : persist : feedback , set feedbackTopic id : topic Id
    @Transactional
    @Override
    public void addFeedback(Integer topicId, FeedbackForm feedback) {
        CfsTopic topic = new CfsTopic();
        topic.setId(topicId);// set id
        CfsFeedback fbk = new CfsFeedback();
        fbk.setCfsTopic(topic);
        fbk.setDate(new Date());
        fbk.setName(feedback.getName());
        fbk.setEmail(feedback.getEmail());
        fbk.setFeedback(feedback.getFeedback());
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(fbk);// persist
        session.flush();// flush

    }

    // delete feedback
    @Transactional
    @Override
    public void delFeedback(Integer topicId, Integer feedbackId) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(CfsFeedback.class);
        criteria.add(Restrictions.like("id",feedbackId));
        criteria.add(Restrictions.like("cfsTopic.id",topicId));
        CfsFeedback feedback = (CfsFeedback) criteria.uniqueResult();
        session.delete(feedback);// delete the feedback

    }

    // update the feedback
    @Transactional
    @Override
    public void updateFeedback(Integer topicId, FeedbackForm feedback) {
        CfsTopic topic = new CfsTopic();
        topic.setId(topicId);

        CfsFeedback fbk = new CfsFeedback();
        fbk.setId(feedback.getId());
        fbk.setCfsTopic(topic);
        fbk.setDate(new Date());
        fbk.setName(feedback.getName());
        fbk.setEmail(feedback.getEmail());
        fbk.setFeedback(feedback.getFeedback());
        Session session = this.sessionFactory.getCurrentSession();
        session.update(fbk);
        session.flush();

    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public CfsFeedback getFeedback(Integer topicId, Integer feedbackId) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(CfsFeedback.class);
        crit.add(Restrictions.like("id",feedbackId));
        crit.add(Restrictions.like("cfsTopic.id",topicId));
        List<CfsFeedback> feedbacks = crit.list();
        return feedbacks.get(0);
    }



}

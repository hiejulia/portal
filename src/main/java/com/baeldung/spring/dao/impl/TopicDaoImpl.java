package com.baeldung.spring.dao.impl;


import java.util.Date;
import java.util.List;

import com.baeldung.spring.dao.TopicDao;
import com.baeldung.spring.entity.data.CfsTopic;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
//@Transactional
public class TopicDaoImpl implements TopicDao {

    // Session factory
    private SessionFactory sessionFactory;

    // autowired
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // get all topcis
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public List<CfsTopic> getAllTopics() {
        Session session = this.sessionFactory.getCurrentSession();
        List<CfsTopic> topics = session.createQuery("from CfsTopic").list();
        return topics;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public CfsTopic getTopic(int topicId) {
        Session session = this.sessionFactory.getCurrentSession();
        // Create criteria : Topic.class
        Criteria crit = session.createCriteria(CfsTopic.class);
        crit.add(Restrictions.like("id",topicId));
        List<CfsTopic> topics = crit.list();
        return topics.get(0);
    }

    @Transactional
    @Override
    public void addTopic(String title, String description, Date date) {
        CfsTopic topic = new CfsTopic();
        topic.setTitle(title);
        topic.setDescription(description);
        topic.setDate(date);
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(topic);// persist
        session.flush();// flush

    }

    @Transactional
    @Override
    public void delTopic(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        CfsTopic topic = (CfsTopic ) session.createCriteria(CfsTopic.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(topic);
    }

    @Transactional
    @Override
    public void updateTopic(CfsTopic topic) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(topic);
        session.flush();

    }



}

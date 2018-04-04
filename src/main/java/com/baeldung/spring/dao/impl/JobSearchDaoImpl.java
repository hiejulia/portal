package com.baeldung.spring.dao.impl;


import java.util.List;

import com.baeldung.spring.entity.JobPosting;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class JobSearchDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public List<JobPosting> search(String keyword, String loc) {
        // TODO Auto-generated method stub
        try {
            sessionFactory.getCurrentSession().getTransaction().begin();
            System.out.println(keyword+"---------------------------");
            Query q = sessionFactory.getCurrentSession().createQuery("from JobPosting where title = :keyword or location = :loc");
            q.setString("keyword", keyword);
            q.setString("loc", loc);
            //q.setString("roletype", roletype);
            //q.setString("password", password);

            // commit();
            List<JobPosting> list = q.list();
            return list;
        } catch (HibernateException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();

        }



    }






}
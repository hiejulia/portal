package com.baeldung.spring.dao.impl;

import com.baeldung.spring.entity.JobSeeker;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
//@Component
public class AdminDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    // delete Job Seeker account
    public void delete(JobSeeker person)
            throws HibernateException {
        try {
            sessionFactory.openSession();
            sessionFactory.getCurrentSession().delete(person);
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (HibernateException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
        }
    }

    // check if job seeker exist
    public JobSeeker checkUserExists(String username) throws Exception{

        try {
            System.out.println( "username >>>" + username);
            //System.out.println( "password >>>" + password);
            Query query = sessionFactory.getCurrentSession().createQuery("from jobseeker where username = :username ");

            query.setString("username", username);
            //query.setString("password", password);

            JobSeeker personDetails = (JobSeeker) query.uniqueResult();

            if(personDetails!=null){
                System.out.println("user exits");
            }
            sessionFactory.getCurrentSession().close();// close transaction
            return personDetails;
        } catch (HibernateException e) {
            // print stack trace
            e.printStackTrace();
            // roll back
            sessionFactory.getCurrentSession().getTransaction().rollback();
            throw new Exception("Could not get user " + username, e);
        }
    }


}

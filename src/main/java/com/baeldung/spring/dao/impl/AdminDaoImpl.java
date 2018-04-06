package com.baeldung.spring.dao.impl;

import com.baeldung.spring.entity.Company;
import com.baeldung.spring.entity.JobPosting;
import com.baeldung.spring.entity.JobSeeker;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        } catch(Exception ex){
//            logger.error(ex.toString());
            sessionFactory.getCurrentSession().getTransaction().rollback();

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

    // Get company by name
    public List<Company> getByName(String companyName) {
        Session session = sessionFactory.getCurrentSession();
        return (List<Company>) session.createQuery(
                "select c from Company c where LOWER(c.name) like :companyName")
                .setParameter("companyName", "%"+companyName.toLowerCase()+"%").list();
    }

    // count the number of companies

    public Integer totalCount() {
        Session session = sessionFactory.getCurrentSession();
        return ((Long)session.createQuery("select count(*) from Company").uniqueResult()).intValue();
    }


    public List<Company> getAllByPage(int offsetData, int limitData) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Company").setFirstResult(offsetData).setMaxResults(limitData).list();
    }



    public void update(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.update(company);
    }

    // get job posting by company

//    public List<JobPosting> getByCompany(Company company) {
//        Session session = sessionFactory.getCurrentSession();
//        return (List<JobPosting>) session.createQuery(
//                "select j from jobposting j where j.company_id = :id")
//                .setParameter("id", company.getCompanyId()).list();
//    }




}

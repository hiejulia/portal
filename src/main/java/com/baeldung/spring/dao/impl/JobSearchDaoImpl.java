package com.baeldung.spring.dao.impl;


import java.util.ArrayList;
import java.util.List;

import com.baeldung.spring.entity.JobPosting;
import org.hibernate.*;
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
            return null;

        }



    }

    // implement full text search
    public List<JobPosting> searchWithMySQLFullTextSearch(String searchTerm){
        try {
            // Prep work
//            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();

            // Get All Employees
            Transaction tx = session.beginTransaction();
//            SELECT * FROM tutorial WHERE MATCH(title,description) AGAINST ('left right' IN NATURAL LANGUAGE MODE);
            String sql = "SELECT * FROM jobposting WHERE MATCH(title,description) AGAINST ("+searchTerm+ "IN NATURAL LANGUAGE MODE)";
            SQLQuery query = session.createSQLQuery(sql);
            List<Object[]> rows = query.list();
            List<JobPosting> returnJobPostings = new ArrayList<JobPosting>();
            for(Object[] row : rows){

                JobPosting jobPosting = new JobPosting();
//                jobPosting.setjobId(Long.parseLong(row[0].toString());
                jobPosting.setTitle(row[1].toString());
                jobPosting.setSalary(row[2].toString());
                returnJobPostings.add(jobPosting);

            }
            return returnJobPostings;


        }catch(HibernateException e){
            // roll back
            sessionFactory.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }

    }






}
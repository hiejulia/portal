package com.baeldung.spring.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.baeldung.spring.dao.ReportDao;
import com.baeldung.spring.entity.JobApplication;
import com.baeldung.spring.entity.JobPosting;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ReportDaoImpl implements ReportDao {


    @PersistenceContext
    private EntityManager entityManagerFactory;


    @Override
    public List<JobApplication> getJobApplications() {
        String qlString = "SELECT j FROM jobapplication j";
        TypedQuery<JobApplication> query = entityManagerFactory.createQuery(qlString, JobApplication.class);
        return query.getResultList();

    }

    @Override
    public List<JobPosting> getJobPosting() {
        String qlString = "SELECT j FROM jobposting j";
        TypedQuery<JobPosting> query = entityManagerFactory.createQuery(qlString, JobPosting.class);
        return query.getResultList();
    }

    @Override
    public JobApplication getJobApplicationById(Long id) {
        String qlString = "SELECT j FROM JobApplication j WHERE j.id = ?1";
        TypedQuery<JobApplication> query = entityManagerFactory.createQuery(qlString, JobApplication.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
}
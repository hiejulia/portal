package com.baeldung.spring.dao.impl;


import com.baeldung.spring.entity.JobSeeker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class AccountDaoImpl {

    @PersistenceContext
    private EntityManager entityManagerFactory;

    @Transactional
    public void setStudentAccount(JobSeeker jobSeeker) {
        entityManagerFactory.persist(jobSeeker);
        entityManagerFactory.flush();// sync the database
    }





}

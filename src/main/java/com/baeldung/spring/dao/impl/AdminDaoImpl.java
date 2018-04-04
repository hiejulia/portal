package com.baeldung.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
//@Component
public class AdminDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;
}

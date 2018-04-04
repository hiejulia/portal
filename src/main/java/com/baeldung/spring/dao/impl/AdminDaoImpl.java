package com.baeldung.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;
}

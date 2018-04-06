package com.baeldung.spring.dao.impl;

import java.util.List;

import com.baeldung.spring.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//@Repository
public class CompanySearchDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    // search for company
    @SuppressWarnings("unchecked")
    public List<Company> searchCompany(String searchTerm)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        @SuppressWarnings("unchecked")
        List<Company> companyList = currentSession.createCriteria(Company.class)
                .add(Restrictions.disjunction()
                        .add(Restrictions.ilike("discription",
                                searchTerm,
                                MatchMode.ANYWHERE))
                        .add(Restrictions.ilike("companyName",
                                searchTerm,
                                MatchMode.ANYWHERE))
                        .add(Restrictions.ilike("companyUser",
                                searchTerm,
                                MatchMode.ANYWHERE)))

                .list();

        return companyList;
    }

}

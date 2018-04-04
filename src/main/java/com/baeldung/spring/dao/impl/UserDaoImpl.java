/**
 * 
 */
package com.baeldung.spring.dao.impl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.baeldung.spring.dao.AbstractDao;
import com.baeldung.spring.entity.JobSeeker;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.spring.dao.UserDao;


@Repository
@Transactional
@Service
public class UserDaoImpl extends AbstractDao<Integer, JobSeeker> implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;



}

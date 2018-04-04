package com.baeldung.spring.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.spring.dao.JobPostingDao;
import com.baeldung.spring.entity.Company;
import com.baeldung.spring.entity.JobPosting;

/**
 * @author surendrary
 *
 */
@Repository
@Transactional
@Service
public class JobPostingDaoImpl implements JobPostingDao {

	@PersistenceContext
	private EntityManager entityManager;

	// creta job posting : job : cid
	@Override
	public JobPosting createJobPosting(JobPosting job, int cid) {
		try {

			Company c = entityManager.find(Company.class, cid);
			job.setCompany(c);

			// save the company
			entityManager.persist(job);// save job into databse :


		} catch (Exception e) {
			e.printStackTrace();
		}
		return job;
	}

	@Override
	public JobPosting getJobPosting(int id) {
		JobPosting j = null;
		// find JobPosting ; find JobPosting .class, id
		j = entityManager.find(JobPosting.class, id);

		return j;
	}

	@Override
	public boolean deleteJobPosting(int id) {
		JobPosting p = getJobPosting(id);
		if (p != null) {
			entityManager.remove(p);// job postig : remove
		} else {
			return false;
		}
		return true;
	}

	// update job posting : id
	@Override
	public JobPosting updateJobPosting(JobPosting p) {

		JobPosting p1 = getJobPosting(p.getJobId());
		p1.setDescription(p.getDescription());
		p1.setLocation(p.getLocation());
		p1.setResponsibilities(p.getResponsibilities());
		p1.setSalary(p.getSalary());
		p1.setState(p.getState());
		p1.setTitle(p.getTitle());
		try {
			if (p1 != null) {
				entityManager.merge(p1);// update : merge
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p1;
	}
}
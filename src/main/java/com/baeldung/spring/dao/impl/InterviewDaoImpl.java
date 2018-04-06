
	package com.baeldung.spring.dao.impl;

	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import javax.persistence.Query;

	import com.baeldung.spring.mail.EmailServiceImpl;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

	import com.baeldung.spring.dao.InterestedDao;
import com.baeldung.spring.dao.InterviewDao;
import com.baeldung.spring.entity.Interested;
import com.baeldung.spring.entity.Interview;
import com.baeldung.spring.entity.JobPosting;

	
	 
	@Repository
	@Transactional
	@Service
	public class InterviewDaoImpl implements InterviewDao {

		// entity manager
		@PersistenceContext
		private EntityManager entityManager;

		@Autowired
		private EmailServiceImpl emailService;

		@Override
		public Interview createInterview(int jobseekerid, String company, String location, String datetime, String flag) {
			Interview interview = new Interview();
			interview.setCompany(company);
			interview.setJobseekerid(jobseekerid);
			interview.setDatetime(datetime);
			interview.setLocation(location);
			interview.setFlag("false");
			entityManager.merge(interview);
			
			return interview;
		}

		
		@Override
		public String acceptInterview(int jobseekerid) {
			Interview interview = new Interview();
			interview.setFlag("true");
			Query query = entityManager.createQuery("UPDATE interview SET flag = true WHERE jobseekerid= :id");
			query.setParameter("id", jobseekerid);
			entityManager.merge(interview);
			// send email when applicant accept the interview
			emailService.sendMessageWithAttachment((interview.getJobseekerid() +""),"Invitation to interview",interview.getCompany()+interview.getFlag()+interview.getLocation(),interview.getDatetime());


			// end send email when
			return "updated";
		}


		@Override
		public List<Interview> getAllInterviews(int jobseekerid) {
			
			//Query query = entityManager.createQuery("SELECT company, location, time FROM interview WHERE jobseekerid = :jobseekerid");
			return null;
		}

		
		

	}



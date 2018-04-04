package com.baeldung.spring.dao;

import java.util.List;

import com.baeldung.spring.entity.Company;


public interface CompanyDao {
	
	
	/**
	 * @param emailid
	 * @return password for the given emailId
	 */
	// password lookup : emailId
	public List<String> PasswordLookUp(String emailid);
	
	/**
	 * @param com
	 * @return Created company
	 * @throws Exception
	 */
	// create company : Company company
	public Company createCompany(Company com) throws Exception;

	/**
	 * @param js
	 * @return Updated company
	 */
	// update company : companyId
	public Company updateCompany(Company js);

	/**
	 * @param id
	 * @return Company
	 */
	// get company by id
	public Company getCompany(int id);
	
	/**
	 * @param c
	 */
	// verify company
	public void verify(Company c);
	
	/**
	 * @param companyId
	 * @param state
	 * @return List of jobs according to the state
	 */
	// get jobs by company: int companyId : get jobs: int companyId
	public List<?> getJobsByCompany(int companyId);

	/**
	 * @param emailid
	 * @return
	 */
	// get company id from email
	public List<Integer> getCompanyIdFromEmail(String emailid);
	
	

}

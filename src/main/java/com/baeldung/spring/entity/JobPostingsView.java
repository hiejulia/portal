/**
 * 
 */
package com.baeldung.spring.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "jobpostingsview")
public class JobPostingsView {

	@Id
	@Column(name = "jobId")
	private int jobId;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "responsibilities")
	private String responsibilites;

	@Column(name = "location")
	private String location;

	@Column(name = "salary")
	private String salary;

	@Column(name = "companyId")
	private int companyId;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "keywords")
	private String keywords;

	@Column(name = "state")
	private int state;



}

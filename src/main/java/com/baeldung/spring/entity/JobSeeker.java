/**
 * 
 */
package com.baeldung.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

@Entity
@Table(name = "jobseeker")
@Data
public class JobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "jobSeekerId", unique = true, nullable = false)
	private int jobseekerId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "emailId")
	private String emailId;

	@Column(name = "password")
	@Transient
	private String password;

	@Column(name = "workEx")
	private int workEx;

	@Column(name = "highestEducation")
	private int highestEducation;

	@Column(name = "skills")
	private String skills;

	@Column(name = "verified")
	private boolean verified;

	@Column(name = "verificationCode")
	private int verificationCode;

	// Join relationship other table

	// interested Job
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "interested", joinColumns = @JoinColumn(name = "jobSeekerId", referencedColumnName = "jobSeekerId"), inverseJoinColumns = @JoinColumn(name = "jobId"))
	private List<JobPosting> interestedjobs;

	// job app list
	@OneToMany(mappedBy="jobSeeker", cascade = CascadeType.ALL)
	@OrderBy("id desc")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="appId")
	private List<JobApplication> jobApplicationList;

	// NotificationLog
	@OneToMany(mappedBy="user")
	private List<NotificationLog> notificationLogs = new ArrayList<>();

	



}

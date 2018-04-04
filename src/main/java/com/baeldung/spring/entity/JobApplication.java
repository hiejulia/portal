/**
 * 
 */
package com.baeldung.spring.entity;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;


@Entity
@Table(name = "jobapplication")
@Data
public class JobApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "appId", unique = true, nullable = false)
	private int appId;
	
	@ManyToOne
	@JoinColumn(name="jobId")
	private JobPosting jobposting;
	
	@ManyToOne
	@JoinColumn(name="jobSeekerId")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="jobSeekerId")
	private JobSeeker jobSeeker;
	
	@Column(name="resume")
	private boolean resume;
	
	@Column(name="resumePath")
	private String resumePath;
	
	@Column(name="state")
	private int state;
	
	@Column(name="interviewFlag")
	private boolean interviewFlag;
	
	@Column(name="interviewLocation")
	private String interviewLocation;
	
	@Column(name="interviewTime")
	private Date interviewTime;
	
	@Column(name="interviewAccepted")
	private boolean interviewAccepted;

	// update degree of the applicant
	@ElementCollection
	@CollectionTable(name = "application_degrees",
			joinColumns = @JoinColumn(name = "job_application_id") )
	@OrderBy("year desc")
	private List<Degree> degrees;

	// cv
	@OneToOne
	private File cv;

	@OneToOne
	@JoinColumn(name = "research_statement_id")
	private File researchStatement;


	@OneToOne
	@JoinColumn(name = "teaching_statement_id")
	private File teachingStatement;


	@OneToMany(mappedBy = "job_application",
			cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@OrderColumn(name = "round_index")
	private List<Round> rounds;



}

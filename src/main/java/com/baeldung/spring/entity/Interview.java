package com.baeldung.spring.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="interview")
@Data
public class Interview {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name ="ID", unique = true, nullable = false)
	private int ID;
//	
//	@Column(name ="jobId")
//	private int jobId;
	
	@Column(name ="company")
	private String company;
	
	@Column(name ="jobseekerid")
	private int jobseekerid;
	
	@Column(name ="location")
	private String location;


	@Column(name ="datetime")
	private String datetime;
	
	@Column(name ="flag")
	private String flag;
	


}

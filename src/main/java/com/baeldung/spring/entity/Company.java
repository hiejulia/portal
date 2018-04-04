/**
 * 
 */
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
@Table(name = "company")
@Data
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "companyId", unique = true, nullable = false)
	private int companyId;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="headquarters")
	private String headquarters;
	
	@Column(name="companyUser")
	private String companyUser;
	
	@Column(name="password")
	private String password;
	
	@Column(name="description")
	private String description;

	@Column(name="verified")
	private boolean verified;

	@Column(name="verificationCode")
	private int verificationCode;


}

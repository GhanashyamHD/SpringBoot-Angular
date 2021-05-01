package com.wolken.wolkenapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Data
@Entity
@Table(name="emp_details")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="firstName")
	private String firstName ;
	@Column(name="lastName")
	private String lastName;
	@Column(name="emailId")
	private String emailId;
	@Column(name="dob")
	private String dob;
	@Column(name ="phoneNo")
	private long phoneNo;
	
	
	
	

}

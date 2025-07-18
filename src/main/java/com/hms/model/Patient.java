package com.hms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	@Column(name = "patient_code")
	private int patientCode;
	
	@Column(name = "patient_name")
	private String patientName;
	

	@Column(name = "visit_amount") 
	private Integer visitAmount;


	@Column(name = "age")
	private int age;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;

//	@Column(name = "dob")
//	private Date dob;

	@Column(name = "gender")
	private String gender;

	@Column(name = "phone")
	private String phone;

//	@Column(name = "last_visit")
//	private Date lastVisit;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date lastVisit;
	
	@Column(name = "created_by_code")
    private String createdByCode ;

	@Column(name = "created_by_name")
    private String createdByName ;

	@Column(name = "created_at")
    private Date createdAt ;
	
	@Column(name = "updated_by_code")
    private String updatedByCode ;
	
	@Column(name = "updated_by_name")
    private String updatedByName ;

	@Column(name = "updated_at")
    private Date updatedAt ;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public int getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(int patientCode) {
		this.patientCode = patientCode;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getVisitAmount() {
		return visitAmount;
	}

	public void setVisitAmount(Integer visitAmount) {
		this.visitAmount = visitAmount;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getCreatedByCode() {
		return createdByCode;
	}

	public void setCreatedByCode(String createdByCode) {
		this.createdByCode = createdByCode;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedByCode() {
		return updatedByCode;
	}

	public void setUpdatedByCode(String updatedByCode) {
		this.updatedByCode = updatedByCode;
	}

	public String getUpdatedByName() {
		return updatedByName;
	}

	public void setUpdatedByName(String updatedByName) {
		this.updatedByName = updatedByName;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}

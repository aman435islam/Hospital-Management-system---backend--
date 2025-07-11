package com.hms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "labTest")
@Table(name = "labTest")
public class LabTest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	@Column(name = "test_code")
	private long testCode;
	
	@Column(name = "test_type")
	private String testType;
	
	@Column(name = "test_name")
	private String testName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "reported_by")
	private String reportedBy;
	
	
	

	
    
	@Column(name = "appointment_code")
	private int appointmentCode;
	
	@Column(name = "appointment_id")
	private int appointmentId;
		
	@Column(name = "prescription_code")
	private int prescriptionCode;
	
	@Column(name = "prescription_id")
	private long prescriptionId;

	@Column(name = "notes")
	private String notes;


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

	public long getTestCode() {
		return testCode;
	}

	public void setTestCode(int testCode) {
		this.testCode = testCode;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
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

	public int getAppointmentCode() {
		return appointmentCode;
	}

	public void setAppointmentCode(int appointmentCode) {
		this.appointmentCode = appointmentCode;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getPrescriptionCode() {
		return prescriptionCode;
	}

	public void setPrescriptionCode(int prescriptionCode) {
		this.prescriptionCode = prescriptionCode;
	}




	public long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReportedBy() {
		return reportedBy;
	}

	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}

	
	}


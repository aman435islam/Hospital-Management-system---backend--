package com.hms.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "appointment")
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "appointment_code")
	private int appointmentCode;

	
	@Column(name = "patient_id")
	private int patientId;
	
	@Column(name = "patient_code")
	private int patientCode;

	@Column(name = "patient_name")
	private String patientName;

	@Column(name = "doctor_id")
	private int doctorId;
	
	@Column(name = "doctor_code")
	private int doctorCode;

	@Column(name = "doctor_name")
	private String doctorName;

	@Column(name = "date")
	private String date;

	@Column(name = "department")
	private String department;

	@Column(name = "status")
	private Integer status;

	@Column(name = "madicleHistry")
	private String madicleHistry;

	@Column(name = "bookingDate")
	private String bookingDate;

	@Column(name = "paymentStatus")
	private String paymentStatus;

	

	@Column(name = "created_by_code")
	private String createdByCode;

	@Column(name = "created_by_name")
	private String createdByName;

	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_by_code")
	private String updatedByCode;

	@Column(name = "updated_by_name")
	private String updatedByName;

	@Column(name = "updated_at")
	private Date updatedAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAppointmentCode() {
		return appointmentCode;
	}

	public void setAppointmentCode(int appointmentCode) {
		this.appointmentCode = appointmentCode;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(int doctorCode) {
		this.doctorCode = doctorCode;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMadicleHistry() {
		return madicleHistry;
	}

	public void setMadicleHistry(String madicleHistry) {
		this.madicleHistry = madicleHistry;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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

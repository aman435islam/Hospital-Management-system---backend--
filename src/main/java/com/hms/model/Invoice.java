package com.hms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "invoice_entity")
@Table(name = "invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "appointmentId")
	private Number appointmentId;

	@Column(name = "patientName")
	private String patientName;

	@Column(name = "date")
	private Date date;

	@Column(name = "paymentStatus")
	private String paymentStatus;

	@Column(name = "amountPaid")
	private Number amountPaid;

	@Column(name = "totalAmount")
	private Number totalAmount;

	@Column(name = "dueAmount")
	private Number dueAmount;

	@Column(name = "servives")
	private String servives;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Number getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Number appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Number getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Number amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Number getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Number totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Number getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Number dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getServives() {
		return servives;
	}

	public void setServives(String servives) {
		this.servives = servives;
	}

}

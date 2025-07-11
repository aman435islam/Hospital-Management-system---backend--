package com.hms.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
	@Entity(name = "testPayment")
	@Table(name = "testPayment")	
	public class TestPayment {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String testCode;
	    private Long patientId;
	    private Double amount;

	    @Column(name = "paid_at")
	    private LocalDateTime paidAt;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTestCode() {
			return testCode;
		}

		public void setTestCode(String testCode) {
			this.testCode = testCode;
		}

		public Long getPatientId() {
			return patientId;
		}

		public void setPatientId(Long patientId) {
			this.patientId = patientId;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public LocalDateTime getPaidAt() {
			return paidAt;
		}

		public void setPaidAt(LocalDateTime paidAt) {
			this.paidAt = paidAt;
		}

		
	    
	}

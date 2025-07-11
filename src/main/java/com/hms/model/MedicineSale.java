package com.hms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "medicine_sales")
public class MedicineSale {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name = "prescription_id")
 private Long prescriptionId;
 
 private String patientName;
 private Date saleDate;

 private Double totalAmount;
 private Double paidAmount;
 private Double dueAmount;

 private String paymentMethod;
 private String status; 
 private String soldBy;

 @OneToMany(mappedBy = "medicineSale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
 private List<SaleMedicineDetail> medicines;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getPrescriptionId() {
	return prescriptionId;
}

public void setPrescriptionId(Long prescriptionId) {
	this.prescriptionId = prescriptionId;
}

public String getPatientName() {
	return patientName;
}

public void setPatientName(String patientName) {
	this.patientName = patientName;
}

public Date getSaleDate() {
	return saleDate;
}

public void setSaleDate(Date saleDate) {
	this.saleDate = saleDate;
}

public Double getTotalAmount() {
	return totalAmount;
}

public void setTotalAmount(Double totalAmount) {
	this.totalAmount = totalAmount;
}

public Double getPaidAmount() {
	return paidAmount;
}

public void setPaidAmount(Double paidAmount) {
	this.paidAmount = paidAmount;
}

public Double getDueAmount() {
	return dueAmount;
}

public void setDueAmount(Double dueAmount) {
	this.dueAmount = dueAmount;
}

public String getPaymentMethod() {
	return paymentMethod;
}

public void setPaymentMethod(String paymentMethod) {
	this.paymentMethod = paymentMethod;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getSoldBy() {
	return soldBy;
}

public void setSoldBy(String soldBy) {
	this.soldBy = soldBy;
}

public List<SaleMedicineDetail> getMedicines() {
	return medicines;
}

public void setMedicines(List<SaleMedicineDetail> medicines) {
	this.medicines = medicines;
}


}

package com.hms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "prescribed_medicines")
public class PrescribedMedicineDetail {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String medicineName;
 private String strength;
 private Integer quantityPrescribed;
 private Double pricePerUnit;
 private Double subtotal;

// @ManyToOne(fetch = FetchType.LAZY)
// @JoinColumn(name = "prescription_id")
// private Prescription prescription;
 
 @ManyToOne
 @JoinColumn(name = "prescription_id")
 @JsonBackReference
 private Prescription prescription;


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getMedicineName() {
	return medicineName;
}

public void setMedicineName(String medicineName) {
	this.medicineName = medicineName;
}

public String getStrength() {
	return strength;
}

public void setStrength(String strength) {
	this.strength = strength;
}

public Integer getQuantityPrescribed() {
	return quantityPrescribed;
}

public void setQuantityPrescribed(Integer quantityPrescribed) {
	this.quantityPrescribed = quantityPrescribed;
}

public Double getPricePerUnit() {
	return pricePerUnit;
}

public void setPricePerUnit(Double pricePerUnit) {
	this.pricePerUnit = pricePerUnit;
}

public Double getSubtotal() {
	return subtotal;
}

public void setSubtotal(Double subtotal) {
	this.subtotal = subtotal;
}

public Prescription getPrescription() {
	return prescription;
}

public void setPrescription(Prescription prescription) {
	this.prescription = prescription;
}



}

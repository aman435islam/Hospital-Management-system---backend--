package com.hms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "prescription")
public class Prescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "prescription_code")
	private Number prescriptionCode;
	

	
	//patient details
	@Column(name = "patient_id")
	private long patientId;
	
	@Column(name = "patient_code")
	private int patientCode;
	
	@Column(name = "patient_name")
	private String patientName;
	
	@Column(name = "age")
	private int age;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "gender")
	private String gender;

	@Column(name = "phone")
	private String phone;

	@Column(name = "lastVisit")
	private Date lastVisit;
	
	
	//doctor details
	@Column(name = "doctor_id")
	private int doctorId;
	
	@Column(name = "doctor_code")
	private int doctorCode;
	
	@Column(name = "doctor_name")
	private String doctorName;
	
	@Column(name = "specialize")
	private String specialize;

	@Column(name = "contact")
	private String contact;

	@Column(name = "availability")
	private String availability;

	@Column(name = "email")
	private String email;

	@Column(name = "roomNumber")
	private String roomNumber;
	
	
	//appointment details
	@Column(name = "appointment_id")
	private int appointmentId;

	@Column(name = "appointment_code")
	private int appointmentCode;
	
	@Column(name = "date")
	private Date date;

	@Column(name = "department")
	private String department;

	@Column(name = "status")
	private Integer status;

	@Column(name = "madicleHistry")
	private String madicleHistry;

	@Column(name = "bookingDate")
	private Date bookingDate;

	@Column(name = "paymentStatus")
	private String paymentStatus;
	
	
//	  @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, fetch = FetchType .LAZY)
//	    private List<PrescribedMedicineDetail> prescriptionMedicines;

	  @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	  @JsonManagedReference
	  private List<PrescribedMedicineDetail> prescriptionMedicines;

	

	
	
	public List<PrescribedMedicineDetail> getPrescriptionMedicines() {
		return prescriptionMedicines;
	}

	public void setPrescriptionMedicines(List<PrescribedMedicineDetail> prescriptionMedicines) {
		this.prescriptionMedicines = prescriptionMedicines;
	}

	@Column(name = "created_by_code")
    private String createdByCode ;

	@Column(name = "created_by_name")
    private String createdByName ;

	@Column(name = "created_at")
    private Date createdAt ;
	
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

	public Number getPrescriptionCode() {
		return prescriptionCode;
	}

	public void setPrescriptionCode(Number prescriptionCode) {
		this.prescriptionCode = prescriptionCode;
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

	

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
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

	public String getSpecialize() {
		return specialize;
	}

	public void setSpecialize(String specialize) {
		this.specialize = specialize;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getAppointmentCode() {
		return appointmentCode;
	}

	public void setAppointmentCode(int appointmentCode) {
		this.appointmentCode = appointmentCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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



















//aman new project code:
//
//@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
//private long id;
//
//@Column(name = "appointmentId")
//private Number appointmentId;
//
//@Column(name = "patientName")
//private String patientName;
//
//@Column(name = "doctorId")
//private Number doctorId;
//
//@Column(name = "medication")
//private String medication;
//
//@Column(name = "dosage")
//private String dosage;
//
//@Column(name = "duration")
//private String duration;
//
//@Column(name = "instruction")
//private String instruction;
//
//@Column(name = "status")
//private String status;
//
//public Long getId() {
//	return id;
//}
//
//public void setId(Long id) {
//	this.id = id;
//}
//
//public Number getAppointmentId() {
//	return appointmentId;
//}
//
//public void setAppointmentId(Number appointmentId) {
//	this.appointmentId = appointmentId;
//}
//
//public String getPatientName() {
//	return patientName;
//}
//
//public void setPatientName(String patientName) {
//	this.patientName = patientName;
//}
//
//public Number getDoctorId() {
//	return doctorId;
//}
//
//public void setDoctorId(Number doctorId) {
//	this.doctorId = doctorId;
//}
//
//public String getMedication() {
//	return medication;
//}
//
//public void setMedication(String medication) {
//	this.medication = medication;
//}
//
//public String getDosage() {
//	return dosage;
//}
//
//public void setDosage(String dosage) {
//	this.dosage = dosage;
//}
//
//public String getDuration() {
//	return duration;
//}
//
//public void setDuration(String duration) {
//	this.duration = duration;
//}
//
//public String getInstruction() {
//	return instruction;
//}
//
//public void setInstruction(String instruction) {
//	this.instruction = instruction;
//}
//
//public String getStatus() {
//	return status;
//}
//
//public void setStatus(String status) {
//	this.status = status;
//}

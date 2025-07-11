package com.hms.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmd.dto.PrescriptionDTO;
import com.hms.dao.DoctorDAO;
import com.hms.dao.LabTestDAO;
import com.hms.dao.MedicineDAO;
import com.hms.dao.PrescriptionDAO;
import com.hms.model.Doctor;
import com.hms.model.LabTest;
import com.hms.model.Medicine;
import com.hms.model.Patient;
import com.hms.model.Prescription;



	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api/prescription")  // Corrected
	public class PrescriptionController {

		@Autowired
	    private PrescriptionDAO prescriptionDAO;

	    @GetMapping("/prescription")
	    public List<Prescription> getAllPrescription() {
	        return prescriptionDAO.getAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Prescription> getEmployeeById(@PathVariable(value = "id") int prescriptionId) {
	    	Prescription prescription = prescriptionDAO.getPrescriptionById(prescriptionId);
	        return ResponseEntity.ok().body(prescription);
	    }

	    @PostMapping("/save")
	    public Prescription createEmployee(@RequestBody Prescription prescription) {
	        return prescriptionDAO.save(prescription);
	    }
	    
	
	}
	
	
	
	
	




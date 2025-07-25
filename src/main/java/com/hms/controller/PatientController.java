package com.hms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dao.PatientDAO;
import com.hms.model.Patient;





@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PatientController  {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	
	

	@GetMapping("/patients")
    public List<Map<String, Object>> getAllPatients() {
        String sql = "SELECT id, name FROM patients";
        return jdbcTemplate.queryForList(sql);
    }

	@Autowired
    private PatientDAO patientDAO;

    @GetMapping("/patient")
    public List<Patient> getAllPatient() {
        return patientDAO.getAll();
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getById(@PathVariable(value = "id") long employeeId) {
    	Patient patient = patientDAO.getPatientById(employeeId);
        return ResponseEntity.ok().body(patient);
    }

    @PostMapping("/patient")
    public Patient save(@RequestBody Patient patient) {
        return patientDAO.save(patient);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Patient> update(@PathVariable(value = "id") int patientId,
//         @Validated @RequestBody Patient patientDetails) {
//    	Patient patient = patientDAO.getPatientById(patientId);
//    	patient.setPatientCode(patientDetails.getPatientCode());
//    	patient.setPatientName(patientDetails.getPatientName());
//    	patient.setVisitAmount(patientDetails.getVisitAmount());
//    	patient.setAge(patientDetails.getAge());
//    	patient.setDob(patientDetails.getDob());
//    	patient.setGender(patientDetails.getGender());
//    	patient.setPhone(patientDetails.getPhone());
//    	patient.setLastVisit(patientDetails.getLastVisit());
//    
//    	
//    	
//    	
//    	
//        final Patient updatedPatient = patientDAO.save(patient);
//        return ResponseEntity.ok(updatedPatient);
//    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> update(@PathVariable(value = "id") long patientId,
         @Validated @RequestBody Patient patientDetails) {

        Patient patient = patientDAO.getPatientById(patientId);

        patient.setPatientCode(patientDetails.getPatientCode());
        patient.setPatientName(patientDetails.getPatientName());
        patient.setVisitAmount(patientDetails.getVisitAmount());
        patient.setAge(patientDetails.getAge());
        patient.setDob(patientDetails.getDob());
        patient.setGender(patientDetails.getGender());
        patient.setPhone(patientDetails.getPhone());
        patient.setLastVisit(patientDetails.getLastVisit());

        final Patient updatedPatient = patientDAO.update(patient); // ✅ এখানে update() মেথড ব্যবহার করো
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/patient/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") long patientId){
    	Patient patient = patientDAO.getPatientById(patientId);
    	patientDAO.delete(patient);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	

}

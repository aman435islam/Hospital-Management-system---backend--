package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dao.DoctorDAO;
import com.hms.dao.LabTestDAO;
import com.hms.model.Doctor;
import com.hms.model.LabTest;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/labtest")
public class LabTestController {
	@Autowired
    private LabTestDAO labTestDAO;

    @GetMapping("/labTest")
    public List<LabTest> getAllLabTests() {
        return labTestDAO.getAll();
    }

    @GetMapping("/labTest/{id}")
    public ResponseEntity<LabTest> getLabTestById(@PathVariable(value = "id") int labTestId) {
    	LabTest doctor = labTestDAO.getLabTestById(labTestId);
        return ResponseEntity.ok().body(doctor);
    }

    @PostMapping("/save")
    public LabTest createLabTest(@RequestBody LabTest labTest) {
        return labTestDAO.save(labTest);
    }
}

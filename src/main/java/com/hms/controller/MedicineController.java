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


import com.hms.dao.MedicineDAO;
import com.hms.model.Medicine;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/medicine")
public class MedicineController {
	@Autowired
    private MedicineDAO medicineDAO;

    @GetMapping("/medicine")
    public List<Medicine> getAllMedicines() {
        return medicineDAO.getAll();
    }

    @GetMapping("/medicine/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable(value = "id") int medicineId) {
    	Medicine doctor = medicineDAO.getMedicineById(medicineId);
        return ResponseEntity.ok().body(doctor);
    }

    @PostMapping("/save")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineDAO.save(medicine);
    }
}

package com.hms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.servlet.ModelAndView;


import com.hms.dao.AppointmentDAO;
import com.hms.dao.DoctorDAO;
import com.hms.dao.LabTestDAO;
import com.hms.dao.MedicineDAO;
import com.hms.dao.PatientDAO;
import com.hms.dao.PaymentDAO;
import com.hms.model.Appointment;
import com.hms.model.Doctor;
import com.hms.model.LabTest;
import com.hms.model.Medicine;
import com.hms.model.Patient;
import com.hms.model.Payment;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController  {


	@Autowired
    private AppointmentDAO appointmentDAO;

	@Autowired
	private PatientDAO patientDAO;

	@Autowired
	private DoctorDAO doctorDAO;
	
	@Autowired
	private LabTestDAO labTestDAO;
	
	@Autowired
	private MedicineDAO medicineDAO;
	
	@Autowired
	private PaymentDAO paymentDAO;

	@GetMapping("/appointment/getMeta")
	public Map<String, Object> getAllMeta() {

		List<Appointment> apps = appointmentDAO.getAll();
		List<Patient> ptns = patientDAO.getAll();
		List<Doctor> dcrs = doctorDAO.getAll();
//		List<LabTest> lab = labTestDAO.getAll();
//		List<Medicine> med = medicineDAO.getAll();
//		List<Payment> pem = paymentDAO.getAll();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Appointment", apps);
		map.put("patient", ptns);
		map.put("doctor", dcrs);
//		map.put("labTest", lab);
//		map.put("medicine", med);
//		map.put("payment", pem);

		return map;
	}
	
	
	
    @GetMapping("/appointment")
    public List<Appointment> getAllEmployees() {
        return appointmentDAO.getAll();
    }


    @GetMapping("/appointment/approve")
    public List<Appointment> getAllApp() {
        return appointmentDAO.getAllApp();
    }
    
    @GetMapping("/appointment/{id}")
    public ResponseEntity<Appointment> getEmployeeById(@PathVariable(value = "id") int employeeId) {
    	Appointment appointment = appointmentDAO.getAppointmentById(employeeId);
        return ResponseEntity.ok().body(appointment);
    }

    @PostMapping("/appointment")
    public Appointment createEmployee(@RequestBody Appointment appointment) {
    	appointment.setStatus(0);
        return appointmentDAO.save(appointment);
    }

    @PutMapping("/appointment/{id}")
    public ResponseEntity<Appointment> updateEmployee(@PathVariable(value = "id") int appointmentId,
         @Validated @RequestBody Appointment appointmentDetails) {
    	Appointment appointment = appointmentDAO.getAppointmentById(appointmentId);
    	appointment.setStatus(1);

    	
        final Appointment updatedPatient = appointmentDAO.update(appointment);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/appointment/{id}")
    public Map<String, Boolean> deleteAppointment(@PathVariable(value = "id") int appointmentId){
    	Appointment appointment = appointmentDAO.getAppointmentById(appointmentId);
    	appointmentDAO.delete(appointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	

	

}


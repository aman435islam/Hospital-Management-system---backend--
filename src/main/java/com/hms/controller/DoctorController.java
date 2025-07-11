package com.hms.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.hms.dao.DoctorDAO;
import com.hms.dao.PatientDAO;
import com.hms.model.Doctor;
import com.hms.repository.DoctorRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DoctorController {

	 	@Autowired
	    private JdbcTemplate jdbcTemplate;

	    @GetMapping("/doctors")
	    public List<Map<String, Object>> getAllDoctors() {
	        String sql = "SELECT id, name FROM doctors";
	        return jdbcTemplate.queryForList(sql);
	    }


	@Autowired
    private DoctorDAO doctorDAO;

    @GetMapping("/doctor")
    public List<Doctor> getAllEmployees() {
        return doctorDAO.getAll();
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor> getEmployeeById(@PathVariable(value = "id") int doctorId) {
    	Doctor doctor = doctorDAO.getDoctorById(doctorId);
        return ResponseEntity.ok().body(doctor);
    }

    @PostMapping("/doctor")
    public Doctor createEmployee(@RequestBody Doctor doctor) {
        return doctorDAO.save(doctor);
    }

    @PutMapping("/doctor/{id}")
    public ResponseEntity<Doctor> updateEmployee(@PathVariable(value = "id") int patientId,
         @Validated @RequestBody Doctor doctorDetails) {
    	Doctor doctor = doctorDAO.getDoctorById(patientId);
    	doctor.setDoctorCode(doctorDetails.getDoctorCode());
    	doctor.setDoctorName(doctorDetails.getDoctorName());
    	doctor.setSpecialize(doctorDetails.getSpecialize());
    	doctor.setContact(doctorDetails.getContact());
    	doctor.setAvailability(doctorDetails.getAvailability());
    	doctor.setEmail(doctorDetails.getEmail());
    	doctor.setRoomNumber(doctorDetails.getRoomNumber());
    	doctor.setDescription(doctorDetails.getDescription());
    	
  
    	
        final Doctor updatedPatient = doctorDAO.save(doctor);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/doctor/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int doctortId){
    	Doctor doctor = doctorDAO.getDoctorById(doctortId);
    	doctorDAO.delete(doctor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
    
    
    
    
    
    
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    
    
    @PostMapping("/doctor/saveDoctorWithImage")
    public Doctor saveProductWithImage(@RequestPart("doctor") Doctor doctor,
                                        @RequestPart("image") MultipartFile file) throws IOException {
        
        // Save image to static folder
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
        String imagePath = "src/main/resources/static/image/" + file.getOriginalFilename();
        ImageIO.write(image, "jpg", new File(imagePath));
        
        // Save product to DB
        doctor.setImage(file.getOriginalFilename());
        return doctorRepository.save(doctor);
    }
    
    

}







//chatGPT:

//@PostMapping("/saveDoctorWithImage")
//public ResponseEntity<?> saveDoctorWithImage(@RequestPart("doctor") Doctor doctor,
//                                           @RequestPart("image") MultipartFile file) {
//  try {
//      String uploadDir = "src/main/resources/static/image/";
//      File dir = new File(uploadDir);
//      if (!dir.exists()) dir.mkdirs();
//
//      String filename = file.getOriginalFilename();
//      Path filepath = Paths.get(uploadDir + filename);
//      Files.copy(file.getInputStream(), filepath, StandardCopyOption.REPLACE_EXISTING);
//      
//      doctor.setImage(filename);
//      Doctor saved = doctorRepository.save(doctor);
//
//      return ResponseEntity.ok(saved);
//  } catch (Exception e) {
//      e.printStackTrace(); // for debugging
//      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save doctor with image");
//  }
//}


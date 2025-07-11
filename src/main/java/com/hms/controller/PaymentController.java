package com.hms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hms.dao.PaymentDAO;
import com.hms.model.Payment;
import com.hms.model.Payment;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/appPayment")
public class PaymentController {

	@Autowired
	PaymentDAO paymentDAO;

	
	   @GetMapping("/{id}")
	    public ResponseEntity<Payment> getEmployeeById(@PathVariable(value = "id") int paymentId) {
	    	Payment payment = paymentDAO.getPaymentById(paymentId);
	        return ResponseEntity.ok().body(payment);
	    }

	   
	    @PostMapping("/save")
	    public Payment createEmployee(@RequestBody Payment payment) {
	        return paymentDAO.save(payment);
	    }
	    
	    @GetMapping("/all")
	    public List<Payment> getAllPayments() {
	        return paymentDAO.getAll();
	    }

}

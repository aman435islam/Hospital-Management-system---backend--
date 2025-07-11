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

import com.hms.dao.PaymentDAO;
import com.hms.dao.TestPaymentDAO;
import com.hms.model.Payment;
import com.hms.model.TestPayment;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/TestPayment")
public class TestPaymentController {

	@Autowired
	TestPaymentDAO testPaymentDAO;

	
	   @GetMapping("/{id}")
	    public ResponseEntity<TestPayment> getTestPaymentById(@PathVariable(value = "id") int testPaymentId) {
		   TestPayment payment = testPaymentDAO.getTestPaymentById(testPaymentId);
	        return ResponseEntity.ok().body(payment);
	    }

//	    @PostMapping("/save")
//	    public TestPayment createTestPayment(@RequestBody TestPayment testPayment) {
//	        return testPaymentDAO.save(testPayment);
//	    }
//	    
//	    @GetMapping("/check/{testCode}")
//	    public List<TestPayment> getAllTestPayments() {
//	        return testPaymentDAO.getAll();
//	    }
	
	@GetMapping("/all")
	public List<TestPayment> getAllTestPayments() {
	    return testPaymentDAO.getAll();
	}

	   
	   
	// ✅ Check if a testCode has payment
	   @PostMapping("/save")
	    public TestPayment createTestPayment(@RequestBody TestPayment testPayment) {
	        return testPaymentDAO.save(testPayment);
	    }

	    @GetMapping("/check/{testCode}")
	    public boolean isTestPaid(@PathVariable String testCode) {
	        List<TestPayment> payments = testPaymentDAO.getByTestCode(testCode);
	        return !payments.isEmpty();  // true if payment exists
	    }

	   

}

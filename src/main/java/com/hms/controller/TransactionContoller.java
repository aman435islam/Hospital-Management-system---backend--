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

import com.hms.dao.TransactionDAO;
import com.hms.model.Transaction;

	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api/transaction")  // Corrected
	public class TransactionContoller {

		@Autowired
	    private TransactionDAO transactionDAO;

	    @GetMapping("/transaction")
	    public List<Transaction> getAllTransaction() {
	        return transactionDAO.getAll();
	    }

	    @GetMapping("/Transaction/{id}")
	    public ResponseEntity<Transaction> getEmployeeById(@PathVariable(value = "id") int transactionId) {
	    	Transaction transaction = transactionDAO.getTransactionById(transactionId);
	        return ResponseEntity.ok().body(transaction);
	    }

	    @PostMapping("/save")
	    public Transaction createEmployee(@RequestBody Transaction transaction) {
	        return transactionDAO.save(transaction);
	    }
	    
	 
	}
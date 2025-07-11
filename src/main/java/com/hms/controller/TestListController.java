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

import com.hms.dao.TestListDAO;
import com.hms.dao.TestListDAO;
import com.hms.model.TestList;

	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api/TestList")  
	public class TestListController {

		@Autowired
	    private TestListDAO testListDAO;

	    @GetMapping("/all")
	    public List<TestList> getAllTestList() {
	        return testListDAO.getAll();
	    }

	    @GetMapping("/TestList/{id}")
	    public ResponseEntity<TestList> getEmployeeById(@PathVariable(value = "id") int testListId) {
	    	TestList testList = testListDAO.getTestListById(testListId);
	        return ResponseEntity.ok().body(testList);
	    }

	    @PostMapping("/save")
	    public TestList createEmployee(@RequestBody TestList testList) {
	        return testListDAO.save(testList);
	    }
	    
	 
	}
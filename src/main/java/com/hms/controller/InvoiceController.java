package com.hms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hms.dao.InvoiceDAO;
import com.hms.model.Invoice;

@RestController
public class InvoiceController  {

	@Autowired
	InvoiceDAO invoiceDAO;

	

////	@GetMapping(path="/invoice2")
////	public ModelAndView index() {
////		return new ModelAndView("index");	
////	}
//
////	@GetMapping(path="/invoice")
////	public List<Invoice> getAllUsers(){
////		System.out.println("hello");
////		
////		List<Invoice> imt = invoiceDAO.getAllUsers();
////		return imt;
////	}

}

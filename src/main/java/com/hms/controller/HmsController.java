package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hms.dao.HmsDAO;


@RestController
public class HmsController {

//	@Autowired
//	HmsDAO hmsDAO;
//
//	@GetMapping(path = "/test")
//	public ModelAndView index() {
//		return new ModelAndView("index");
//	}
//
//	@GetMapping(path = "/aman")
//	public List<Hms> getAllUsers() {
//		System.out.println("hello");
//
//		List<Hms> imt = hmsDAO.getAllUsers();
//		return imt;
//	}
}
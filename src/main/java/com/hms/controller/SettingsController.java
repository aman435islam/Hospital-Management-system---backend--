package com.hms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hms.dao.SettingsDAO;
import com.hms.model.Settings;

@RestController
public class SettingsController {

	@Autowired
	SettingsDAO settingDAO;

	
//	@GetMapping(path="/settins2")
//	public ModelAndView index() {
//		return new ModelAndView("index");	
//	}
//	

//	@GetMapping(path="/settins")
//	public List<Settings> getAllUsers(){
//		System.out.println("hello");
//		
//		List<Settings> imt = settingDAO.getAllUsers();
//		return imt;
//	}

}

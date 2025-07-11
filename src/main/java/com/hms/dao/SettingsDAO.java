package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.hms.model.Settings;

@Repository(value = "settingDAO")
@Transactional
public class SettingsDAO  {

	@Autowired
	private EntityManager entityManager;
	
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	

	String sql= "from settings_entity";
	public List<Settings> getAllUsers() {
		List<Settings> imt = getSession().createQuery(sql).list();
		return imt;
	}

}

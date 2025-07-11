package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository(value = "hmsDAO")
@Transactional
public class HmsDAO {

	@Autowired
	private EntityManager entityManager;

	// List<User> users = entityManager.unwrap(Session.class).createQuery("from
	// user").list();
//
//	private Session getSession() {
//		return entityManager.unwrap(Session.class);
//	}
//
////	public List<User> getAllUsers() {
////		List<User> users = getSession().createQuery("from user").list();
////		return users;
////	}
//
//	String sql = "from user";
//
//	public List<Hms> getAllUsers() {
//		List<Hms> imt = getSession().createQuery(sql).list();
//		return imt;
//	}

}
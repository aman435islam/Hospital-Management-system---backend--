package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.hms.model.Invoice;

@Repository(value = "invoiceDAO")
@Transactional
public class InvoiceDAO {

	

	@Autowired
	private EntityManager entityManager;
	
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	

	String sql= "from invoice_entity";
	public List<Invoice> getAllUsers() {
		List<Invoice> imt = getSession().createQuery(sql).list();
		return imt;
	}

}

package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.Doctor;
import com.hms.model.Patient;

@Repository(value = "doctorDAO")
@Transactional
public class DoctorDAO {


	 @Autowired
	    private EntityManager entityManager;

	    private Session getSession() {
	        return entityManager.unwrap(Session.class);
	    }


	    public Doctor save(Doctor p){
	    	getSession().save(p);
	    	getSession().flush();
	        return p;
	    }

	    public List<Doctor> getAll(){
	    	String sql = "from doctor";
	        List<Doctor> products = getSession().createQuery(sql).list();
	        return products;
	    }

	    public Doctor getDoctorById(long id) {
	        String sql = "from doctor where id = '" + id + "'";
	        List<Doctor> empList = getSession().createQuery(sql).list();
	        return empList.get(0);

	    }

	    public Doctor update(Doctor p) { 
	        String hql = "update doctor set Code = '"+p.getDoctorCode()+"', Name = '"+p.getDoctorName()+"', Specialize = '"+p.getSpecialize()+"', Contact = '"+p.getContact()+"'"
	        		+ ", Availability = '"+p.getAvailability()+"', Email = '"+p.getEmail()+"', roomNumber = '"+p.getRoomNumber()+"', description = '"+p.getDescription()+"', "
	        				+ "image = '" + p.getImage() + "'  where id = '"+p.getId()+"'";
	        Query q = getSession().createQuery(hql);
	        q.executeUpdate();
	        getSession().flush();
	        return p;
	    }


	    public Doctor delete(Doctor p) {
	    	String sql = "delete doctor where id = '"+p.getId()+"'";
	        int delete = getSession().createQuery(sql).executeUpdate();
	        return p;
	    }
	
}


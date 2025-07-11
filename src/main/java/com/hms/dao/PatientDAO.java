package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.hms.model.Patient;


@Repository(value = "patientDAO")
@Transactional
public class PatientDAO  {

	
	 @Autowired
	    private EntityManager entityManager;

	    private Session getSession() {
	        return entityManager.unwrap(Session.class);
	    }


	    public Patient save(Patient p){
	    	getSession().save(p);
	    	getSession().flush();
	        return p;
	    }

	    public List<Patient> getAll(){
	    	String sql = "from patient";
	        List<Patient> products = getSession().createQuery(sql).list();
	        return products;
	    }

	    public Patient getPatientById(long id) {
	        String sql = "from patient where id = '" + id + "'";
	        List<Patient> empList = getSession().createQuery(sql).list();
	        return empList.get(0);

	    }

	    public Patient update(Patient p) {
	        String hql = "update patient set Code = '"+p.getPatientCode()+"', Name = '"+p.getPatientName()+"', Age = '"+p.getAge()+"', Dob = '"+p.getDob()+"'"
	        		+ ", gender = '"+p.getGender()+"', contact = '"+p.getPhone()+"', lastVisit = '"+p.getLastVisit()+"', VisitAmmount = '"+p.getVisitAmmount()+"'  where id = '"+p.getId()+"'";
	        Query q = getSession().createQuery(hql);
	        q.executeUpdate();
	        getSession().flush();
	        return p;
	    }


	    public Patient delete(Patient p) {
	    	String sql = "delete patient where id = '"+p.getId()+"'";
	        int delete = getSession().createQuery(sql).executeUpdate();
	        return p;
	    }
	


}

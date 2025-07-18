//package com.hms.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import javax.servlet.http.HttpServletRequest;
//import javax.transaction.Transactional;
//
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import com.hms.model.Patient;



//@Repository(value = "patientDAO")
//@Transactional
//public class PatientDAO  {
//
//	
//	 @Autowired
//	    private EntityManager entityManager;
//
//	    private Session getSession() {
//	        return entityManager.unwrap(Session.class);
//	    }

////	    public Patient save(Patient p){
////	    	getSession().save(p);
////	    	getSession().flush();
////	        return p;
////	    }
//  
//	    public Patient save(Patient p){
//	        getSession().saveOrUpdate(p); // এটা insert এবং update উভয় কাজ করে
//	        getSession().flush();
//	        return p;
//	    }
//
//	    
//	    public List<Patient> getAll(){
//	    	String sql = "from patient";
//	        List<Patient> products = getSession().createQuery(sql).list();
//	        return products;
//	    }
//
//	    public Patient getPatientById(long id) {
//	        String sql = "from patient where id = '" + id + "'";
//	        List<Patient> empList = getSession().createQuery(sql).list();
//	        return empList.get(0);
//
//	    }
//
//	    public Patient update(Patient p) {
//	        String hql = "update patient set Code = '"+p.getPatientCode()+"', Name = '"+p.getPatientName()+"', Age = '"+p.getAge()+"', Dob = '"+p.getDob()+"'"
//	        		+ ", gender = '"+p.getGender()+"', contact = '"+p.getPhone()+"', lastVisit = '"+p.getLastVisit()+"', VisitAmmount = '"+p.getVisitAmount()+"'  where id = '"+p.getId()+"'";
//	        Query q = getSession().createQuery(hql);
//	        q.executeUpdate();
//	        getSession().flush();
//	        return p;
//	    }
//
//	    public Patient delete(Patient p) {
//	    	String sql = "delete patient where id = '"+p.getId()+"'";
//	        int delete = getSession().createQuery(sql).executeUpdate();
//	        return p;
//	    }

//}



package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.Patient;

@Repository
@Transactional
public class PatientDAO {

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    // ✅ Save: insert only
    public Patient save(Patient patient) {
        getSession().save(patient);
        getSession().flush();
        return patient;
    }

    // ✅ Update: for existing patient
    public Patient update(Patient patient) {
        getSession().update(patient); // Hibernate standard update
        getSession().flush();
        return patient;
    }

    // ✅ Delete
    public void delete(Patient patient) {
        getSession().delete(patient);
        getSession().flush();
    }

    // ✅ Get All Patients
    public List<Patient> getAll() {
        return getSession().createQuery("from Patient", Patient.class).list();
    }
    
    // ✅ Get by ID
    public Patient getPatientById(long id) {
        return getSession().get(Patient.class, id);
    }
}

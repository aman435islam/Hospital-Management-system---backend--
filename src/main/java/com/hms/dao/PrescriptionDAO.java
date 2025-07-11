package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.Patient;
import com.hms.model.Prescription;

@Repository(value = "prescriptionDAO")
@Transactional
public class PrescriptionDAO  {
	@Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


    public Prescription save(Prescription p){
    	getSession().save(p);
    	getSession().flush();
        return p;
    }

    public List<Prescription> getAll(){
    	String sql = "from Prescription";
        List<Prescription> products = getSession().createQuery(sql).list();
        return products;
    }

   

    public Prescription getPrescriptionById(long id) {
        String jpql = "SELECT p FROM Prescription p LEFT JOIN FETCH p.prescriptionMedicines WHERE p.id = :id";
        return entityManager.createQuery(jpql, Prescription.class)
                            .setParameter("id", id)
                            .getSingleResult();
    }

    
//    public Prescription getPrescriptionById(long id) {
//        String sql = "from Prescription where id = '" + id + "'";
//        List<Prescription> empList = getSession().createQuery(sql).list();
//        return empList.get(0);
//
//    }
//    
}

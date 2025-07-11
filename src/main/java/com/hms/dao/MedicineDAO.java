package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.LabTest;
import com.hms.model.Medicine;
import com.hms.model.Prescription;

@Repository(value = "medicineDAO")
@Transactional
public class MedicineDAO {
	 @Autowired
	    private EntityManager entityManager;

	    private Session getSession() {
	        return entityManager.unwrap(Session.class);
	    }


	    public Medicine save(Medicine p){
	    	getSession().save(p);
	    	getSession().flush();
	        return p;
	    }

	    public List<Medicine> getAll(){
	    	String sql = "from Medicine";
	        List<Medicine> products = getSession().createQuery(sql).list();
	        return products;
	    }

	    public Medicine getMedicineById(long id) {
	        String sql = "from Medicine where id = '" + id + "'";
	        List<Medicine> empList = getSession().createQuery(sql).list();
	        return empList.get(0);

	    }
	    
}

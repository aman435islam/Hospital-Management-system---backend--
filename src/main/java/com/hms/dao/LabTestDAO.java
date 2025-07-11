package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hms.model.LabTest;


@Repository(value = "labTestDAO")
@Transactional
public class LabTestDAO {
	 @Autowired
	    private EntityManager entityManager;

	    private Session getSession() {
	        return entityManager.unwrap(Session.class);
	    }


	    public LabTest save(LabTest p){
	    	getSession().save(p);
	    	getSession().flush();
	        return p;
	    }

	    public List<LabTest> getAll(){
	    	String sql = "from LabTest";
	        List<LabTest> products = getSession().createQuery(sql).list();
	        return products;
	    }

	    public LabTest getLabTestById(long id) {
	        String sql = "from LabTest where id = '" + id + "'";
	        List<LabTest> empList = getSession().createQuery(sql).list();
	        return empList.get(0);

	    }
	    
}

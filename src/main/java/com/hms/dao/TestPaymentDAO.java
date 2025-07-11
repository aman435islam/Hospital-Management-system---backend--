package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hms.model.TestPayment;



@Repository(value = "testPaymentDAO")
@Transactional
public class TestPaymentDAO {
	

	@Autowired
	private EntityManager entityManager;
	
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	
	
	
	public TestPayment save(TestPayment p) {
	    getSession().save(p);
	    getSession().flush();
	    return p;
	}

	public List<TestPayment> getAll() {
	    String hql = "from testPayment";
	    return getSession().createQuery(hql).list();
	}

	public TestPayment getTestPaymentById(long id) {
	    String hql = "from testPayment where id = :id";
	    List<TestPayment> result = getSession().createQuery(hql)
	                                           .setParameter("id", id)
	                                           .list();
	    return result.isEmpty() ? null : result.get(0);
	}

	public List<TestPayment> getByTestCode(String testCode) {
	    String hql = "from testPayment where testCode = :code";
	    return getSession().createQuery(hql)
	                       .setParameter("code", testCode)
	                       .list();
	}
	
	
	

//    public TestPayment save(TestPayment p){
//    	getSession().save(p);
//    	getSession().flush();
//        return p;
//    }
//
//    public List<TestPayment> getAll(){
//    	String sql = "from testPayment";
//        List<TestPayment> testPayment = getSession().createQuery(sql).list();
//        return testPayment;
//    }
//
    public TestPayment getTesttestPaymentById(long id) {
        String sql = "from testPayment where id = '" + id + "'";
        List<TestPayment> testPayment = getSession().createQuery(sql).list();
        return testPayment.get(0);

    }
}

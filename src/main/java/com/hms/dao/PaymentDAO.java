package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.hms.model.Payment;
import com.hms.model.Payment;

@Repository(value = "paymentDAO")
@Transactional
public class PaymentDAO  {

	

	@Autowired
	private EntityManager entityManager;
	
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	

    public Payment save(Payment p){
    	getSession().save(p);
    	getSession().flush();
        return p;
    }

    public List<Payment> getAll(){
    	String sql = "from payment";
        List<Payment> payment = getSession().createQuery(sql).list();
        return payment;
    }

    public Payment getPaymentById(long id) {
        String sql = "from payment where id = '" + id + "'";
        List<Payment> payment = getSession().createQuery(sql).list();
        return payment.get(0);

    }

}

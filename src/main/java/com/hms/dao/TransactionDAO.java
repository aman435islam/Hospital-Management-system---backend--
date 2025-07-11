package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.Transaction;

@Repository(value = "transactionDAO")
@Transactional
public class TransactionDAO {
	@Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


    public Transaction save(Transaction p){
    	getSession().save(p);
    	getSession().flush();
        return p;
    }

    public List<Transaction> getAll(){
    	String sql = "from transaction";
        List<Transaction> products = getSession().createQuery(sql).list();
        return products;
    }

    public Transaction getTransactionById(long id) {
        String sql = "from transaction where id = '" + id + "'";
        List<Transaction> empList = getSession().createQuery(sql).list();
        return empList.get(0);

    }
}

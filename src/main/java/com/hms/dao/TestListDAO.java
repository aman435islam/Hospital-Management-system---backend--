package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.TestList;

@Repository(value = "testListDAO")
@Transactional
public class TestListDAO {
	@Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


    public TestList save(TestList p){
    	getSession().save(p);
    	getSession().flush();
        return p;
    }

    public List<TestList> getAll(){
    	String sql = "from testList";
        List<TestList> products = getSession().createQuery(sql).list();
        return products;
    }

    public TestList getTestListById(long id) {
        String sql = "from testList where id = '" + id + "'";
        List<TestList> empList = getSession().createQuery(sql).list();
        return empList.get(0);

    }
}

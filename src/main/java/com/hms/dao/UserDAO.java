package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.enums.Role;
import com.hms.model.Doctor;
import com.hms.model.User;

@Repository(value = "userDAO")
@Transactional
public class UserDAO{

	
	

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public User getByUsernameAndPassword(String username, String password, Role userRole) {
        String hql = "from user where username = :username and password = :password and userRole = :role";
        List<User> users = getSession()
                .createQuery(hql, User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .setParameter("role", userRole)
                .list();
        return users.isEmpty() ? null : users.get(0);
    }

    public User getUserByUsername(String username) {
        String hql = "from user where username = :username";
        List<User> users = getSession()
                .createQuery(hql, User.class)
                .setParameter("username", username)
                .list();
        return users.isEmpty() ? null : users.get(0);
    }

    public User save(User u) {
        getSession().saveOrUpdate(u);
        getSession().flush();
        return u;
    }

    public List<User> getAll() {
        String hql = "from user";
        return getSession().createQuery(hql, User.class).list();
    }

    public User getUserById(long id) {
        return getSession().get(User.class, id);
    }
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	   @Autowired
//	   private EntityManager entityManager;
//	   
//	   
//	   	private Session getSession() {
//	   		return entityManager.unwrap(Session.class);	   		
//	   	}
//	    
//	
////	public User getByUsername(User user) {
////		System.out.println(user.getUsername());
////		String sql = "from user where username = '" + user.getUsername() + "'";
////	    List<User> users = getSession().createQuery(sql).list();
////		return users.get(0);
////	}
////	
//	   	
//	   	
//	   	public User getByUsernameAndPassword(String username, String password, Role userRole) {
//	   	    System.out.println("Username: " + username);
//	   	    System.out.println("Password: " + password);
//
//	   	    String hql = "from user where username = :username and password = :password and userRole = :role";
//	   	    List<User> users = getSession().createQuery(hql).setParameter("username", username)
//	   	    		.setParameter("password", password).setParameter("role", userRole).list();
//
//	   	    if (users != null && !users.isEmpty()) {
//	   	        return users.get(0);
//	   	    } else {
//	   	        return null;
//	   	    }
//	   	}
//
//	
// public User save(User u){
// 	getSession().save(u);
// 	getSession().flush();
//     return u;
// }
//
// public List<User> getAll(){
// 	String sql = "from user";
//     List<User> us = getSession().createQuery(sql).list();
//     return us;
// }
// 
// 
// public User getUserById(long id) {
//     String sql = "from user where id = '" + id + "'";
//     List<User> userList = getSession().createQuery(sql).list();
//     return userList.get(0);
//
// }
// 
 




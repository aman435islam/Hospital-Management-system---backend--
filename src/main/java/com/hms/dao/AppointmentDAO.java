package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.Appointment;



@Repository(value = "appointmentDAO")
@Transactional
public class AppointmentDAO {

	
	@Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


    public Appointment save(Appointment p){
    	getSession().save(p);
    	getSession().flush();
        return p;
    }

    public List<Appointment> getAll(){
    	String sql = "from appointment";
        List<Appointment> appointment = getSession().createQuery(sql).list();
        return appointment;
    }
    public List<Appointment> getAllApp(){
    	String sql = "from appointment where status=1";
        List<Appointment> appointment = getSession().createQuery(sql).list();
        return appointment;
    }

    public Appointment getAppointmentById(long id) {
        String sql = "from appointment where id = '" + id + "'";
        List<Appointment> empList = getSession().createQuery(sql).list();
        return empList.get(0);

    }

    public Appointment update(Appointment p) {
    	System.out.println(p.getStatus());
        String hql = "update appointment set status = '"+p.getStatus()+"' where id = '"+p.getId()+"'";
        Query q = getSession().createQuery(hql);
        q.executeUpdate();
        getSession().flush();
        return p;
    }


    public Appointment delete(Appointment p) {
    	String sql = "delete appointment where id = '"+p.getId()+"'";
        int delete = getSession().createQuery(sql).executeUpdate();
        return p;
    }


}

package com.ipl.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ipl.model.UserTable;

@SuppressWarnings("rawtypes")
@Repository
@Transactional
public class IplDaoImpl<E> implements IplDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session;

	// checking user name and password
	@SuppressWarnings("unchecked")
	public boolean isValid(String username, String password) {
		session = sessionFactory.openSession();

		Query<UserTable> query = session
				.createQuery("from UserTable u where u.mUsername= :Username " + "and u.mPassword= :Password");
		query.setParameter("Username", username);
		query.setParameter("Password", password);

		List<UserTable> result = query.getResultList(); // getting hql result

		// checking result
		if (result != null && result.size() > 0)
			return true;
		else
			return false;
	}

	// display list of user
	@SuppressWarnings("unchecked")
	public List<E> showList() {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from UserTable");
		List<UserTable> list = query.getResultList();
		
		for (UserTable login : list) {
			System.out.println("Dao:" + login.getmUsername());
		}
		return (List<E>) list;
	}
	
	//delete a record from database
	@SuppressWarnings("unchecked")
	public List<E> delete(int id) {
		System.out.println("Inside delete " + id);
		session = sessionFactory.openSession();
		session.beginTransaction();
		UserTable use = (UserTable) session.load(UserTable.class, new Integer(id));
		System.out.println("Inside delete " + id + " " + use);
		if (use != null) {
			session.delete(use);
			session.flush();
		}
		Query q = session.createQuery("from UserTable");
		List<UserTable> list = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return (List<E>) list; // returning new list
	}
	
	//add a record from database
	public boolean add(Object user) {
		UserTable use=(UserTable)user;
		System.out.println("Inside add "+use.getmName());
		session = sessionFactory.openSession();
		session.beginTransaction();
		int id = (Integer) session.save(use);
		session.getTransaction().commit();
		System.out.println("id= " +id);
		session.close();
		if(id>0){
		return true;
		}
		else return false;
	}

}

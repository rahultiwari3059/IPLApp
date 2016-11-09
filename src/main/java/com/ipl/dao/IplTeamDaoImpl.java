package com.ipl.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ipl.model.Team;
import com.ipl.model.UserTable;

@Repository
@Transactional
public class IplTeamDaoImpl implements IplDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session;

	// checking user name and password
	/*@SuppressWarnings("unchecked")
	public boolean isValid(String username, String password) {
		session = sessionFactory.openSession();

		Query<User> query = session
				.createQuery("from Userinformation u where u.mUsername= :Username " + "and u.mPassword= :Password");
		query.setParameter("Username", username);
		query.setParameter("Password", password);

		List<User> result = query.getResultList(); // getting hql result

		// checking result
		if (result != null && result.size() > 0)
			return true;
		else
			return false;
	}*/

	// display list of user
	public List<Object> showList() {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Team");
		List<Object> list = query.getResultList();
		/*for (Team t : list) {
			System.out.println("Dao:" + t.getTeamName());
		}*/
		return list;
	}
	
	//delete a record from database
	public List<Object> delete(int id) {
		System.out.println("Inside delete " + id);
		session = sessionFactory.openSession();
		session.beginTransaction();
		Team use = (Team) session.load(Team.class, new Integer(id));
		System.out.println("Inside delete " + id + " " + use);
		if (use != null) {
			session.delete(use);
			session.flush();
		}
		Query q = session.createQuery("from Team");
		List<Object> list = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return list; // returning new list
	}
	
	//add a record from database
	public boolean add(Object user) {
		Team t=(Team)user;
		System.out.println("Inside add "+t.getTeamName());
		session = sessionFactory.openSession();
		session.beginTransaction();
		int id = (Integer) session.save(t);
		session.getTransaction().commit();
		System.out.println("id= " +id);
		session.close();
		if(id>0){
		return true;
		}
		else return false;
	}

	public boolean isValid(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	} //......>>>>>>>>>>>>>>>>>>>>>>>>>>.....
}

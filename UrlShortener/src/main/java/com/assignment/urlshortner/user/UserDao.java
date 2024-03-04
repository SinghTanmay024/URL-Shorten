package com.assignment.urlshortner.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserDao {

	Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);
	SessionFactory factory = configuration.buildSessionFactory();

	public void saveUser(User user) throws RuntimeException{
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}

	public User findUserById(int userId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = session.find(User.class, userId);
		transaction.commit();
		session.close();
		return user;
	}
	
	public User findByEmail(String email) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query<User> query = session.createQuery("From User where email=:email", User.class);
		query.setParameter("email", email);
		User user = query.getSingleResult();
		
		transaction.commit();
		session.close();
		return user;
	}
}

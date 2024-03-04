package com.assignment.urlshortner.shorturl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.assignment.urlshortner.user.User;

public class ShortUrlDao {

	Configuration configuration = new Configuration().configure().addAnnotatedClass(ShortURL.class)
			.addAnnotatedClass(User.class);
	SessionFactory factory = configuration.buildSessionFactory();

	public void saveURL(ShortURL url) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(url);
		transaction.commit();
		session.close();
	}

	public ShortURL findUrlByshortURL(String shortURL) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Query<ShortURL> query = session.createQuery("From ShortURL where shortURL=:url", ShortURL.class);
		query.setParameter("url", shortURL);
		ShortURL url = query.getSingleResult();

		transaction.commit();
		session.close();
		return url;
	}

	public List<ShortURL> findAllShortURLByUser(User user) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Query<ShortURL> query = session.createQuery("From ShortURL where user=:user", ShortURL.class);
		query.setParameter("user", user);
		List<ShortURL> urls = query.list();

		transaction.commit();
		session.close();
		return urls;
	}
	
	public ShortURL findShortUrlById(int id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		ShortURL url = session.find(ShortURL.class, id);
		transaction.commit();
		session.close();
		
		return url;
	}
	
	public void deleteURL(ShortURL url) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(url);
		transaction.commit();
		session.close();
	}
	
	public void updateURL(ShortURL url){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(url);
		transaction.commit();
		session.close();
	}
}

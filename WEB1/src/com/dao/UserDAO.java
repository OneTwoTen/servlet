package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.User;
import com.until.HibernateUntils;

public class UserDAO {
	private Session hSession;

	public UserDAO() {
		this.hSession = HibernateUntils.getSession();
	}

	public User store(User entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();
		entity.setId(id);
		return entity;
	}

	public List<User> paginate(int offset, int perPage) {
		String hql = "FROM User";
		Query query = this.hSession.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(offset + perPage);
		List<User> result = query.getResultList();
		return result;
	}

	public User findByID(int id) {
		User entity = this.hSession.get(User.class, id);
		return entity;
	}

	public void update(User entity) {
		try {
			this.hSession.clear();
			this.hSession.beginTransaction();
			this.hSession.update(entity);
			this.hSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.hSession.beginTransaction().rollback();
		}
	}

	public void delete(User entity) {
		Session session = HibernateUntils.getSession();
		session.clear();

		try {
			session.beginTransaction();

			session.delete(entity);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

			session.getTransaction().rollback();
		}
	}

	public User login(String email, String password) {
		String hql = "SELECT entity FROM User entity WHERE entity.password = :password  AND entity.email = :email";
		Query query = this.hSession.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			User entity = (User) query.getSingleResult();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public User findByIdAndEmail(String email) {
		String hql = "SELECT entity FROM User entity WHERE entity.email = :email";
		Query query = this.hSession.createQuery(hql);
		query.setParameter("email", email);
		try {
			User entity = (User) query.getSingleResult();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return findByIdAndEmail(email);
	}
}

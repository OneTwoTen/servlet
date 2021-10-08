package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.Share;
import com.entity.Video;
import com.until.HibernateUntils;

public class ShareDAO {
	private Session hSession;

	public ShareDAO() {
		this.hSession = HibernateUntils.getSession();
	}

	public Share store(Share entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();
		return entity;
	}
	public List<Share> paginate(int offset, int perPage) {
		String hql = "FROM Share";
		Query query = this.hSession.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(offset + perPage);
		List<Share> result = query.getResultList();
		return result;
	}
	public Share findByID(int id) {
		Share entity=this.hSession.get(Share.class, id);
		return entity;
	}
	public void update(Share entity) {
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

	public void delete(Share entity) {
		Session session = HibernateUntils.getSession();
		session.clear();
//		hSession.getSession();
//		hSession.clear();

		try {
			session.beginTransaction();

			session.delete(entity);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

			session.getTransaction().rollback();
		}
	}
}

package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.Favorite;
import com.entity.User;
import com.entity.Video;
import com.until.HibernateUntils;

public class FavoriteDAO {
	private Session hSession;

	public FavoriteDAO() {
		this.hSession = HibernateUntils.getSession();
	}

	public Favorite store(Favorite entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();
		return entity;
	}
	public List<Favorite> paginate(int offset, int perPage) {
		String hql = "FROM Video";
		Query query = this.hSession.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(offset + perPage);
		List<Favorite> result = query.getResultList();
		return result;
	}
	
	public List<Favorite> like(User user) {
		String hql = "SELECT e FROM Favorite e WHERE "
				+ " e.user = :user";
		Query query = this.hSession.createQuery(hql);
		query.setParameter("user", user);
		List<Favorite> result = query.getResultList();
		return result;
	}
	
	public Favorite findByID(int id) {
		Favorite entity=this.hSession.get(Favorite.class, id);
		return entity;
	}
	
	public void update(Favorite entity) {
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

	public void delete(Favorite entity) {
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
	public Favorite findIdVideo(Video video, User user) {
		String hql = "SELECT e FROM Favorite e WHERE "
				+ "e.video = :video"
				+ " AND e.user = :user";
		Query query = this.hSession.createQuery(hql);
		query.setParameter("video", video);
		query.setParameter("user", user);
		Favorite entity = new Favorite();
		try {
			entity = (Favorite) query.getSingleResult();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

package com.dao;

import java.util.List;
import java.util.Iterator;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.Favorite;
import com.entity.FavoriteVideo;
import com.entity.User;
import com.entity.Video;
import com.until.HibernateUntils;


public class VideoDAO {
	private Session hSession;
	
	public VideoDAO() {
		this.hSession = HibernateUntils.getSession();
	}

	public Video store(Video entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();
		return entity;
	}

	public List<Video> paginate(int offset, int perPage) {
		
		String hql = "SELECT e FROM Video e ";
		Query query = this.hSession.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(offset + perPage);
		List<Video> result = query.getResultList();
		return result;
	}

	public Video findByID(int id) {
		Video entity = this.hSession.get(Video.class, id);
		return entity;
	}

	public void update(Video entity) {
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

	public void delete(Video entity) {
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

	public List<FavoriteVideo[]> findVideoFavorite(User userid) {
		String hql = "SELECT v.id, f.user, f.id, v.title, v.poster, v.views, v.description, v.acitve, v.link, f.likedate"
				+ " from Video v INNER JOIN Favorite f ON v.id = f.video WHERE f.user = :userid";
		Query query = this.hSession.createQuery(hql);
		query.setParameter("userid", userid);
		List<FavoriteVideo[]> result = query.getResultList();
//		for (Iterator itr = (Iterator) result.iterator(); itr.hasNext();) {
//			FavoriteVideo[] fv = (FavoriteVideo[]) itr.next();
//			System.out.println("fv"+ fv[0]);
//		}
		return result;
	}
}

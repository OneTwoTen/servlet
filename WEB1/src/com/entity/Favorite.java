package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="favorites")
public class Favorite implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="videoid")
	private Video video;
	
	@Column(name = "likedate")
	private Date likedate;
	
	@Column(name="status")
	private Integer status;

	public Favorite() {
		super();
	}

	public Favorite(Integer id, User user, Video video, Date likedate, Integer status) {
		super();
		this.id = id;
		this.user = user;
		this.video = video;
		this.likedate = likedate;
		this.status = status;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Date getLikedate() {
		return likedate;
	}

	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", user=" + user + ", video=" + video + ", likedate=" + likedate + ", status="
				+ status + "]";
	}
	
}

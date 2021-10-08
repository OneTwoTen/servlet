package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Video implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="poster")
	private String poster;
	
	@Column(name="views")
	private Integer views;
	
	@Column(name="description")
	private String description;
	
	@Column(name = "active")
	private Integer acitve;
	
	@Column(name="link")
	private String link;
	public Video() {
	
	}

	public Video(Integer id, String title, String poster, Integer views, String description, Integer acitve,
			String link, List<Favorite> favorites, List<Share> shares) {
		super();
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.views = views;
		this.description = description;
		this.acitve = acitve;
		this.link = link;
		this.favorites = favorites;
		this.shares = shares;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAcitve() {
		return acitve;
	}

	public void setAcitve(Integer acitve) {
		this.acitve = acitve;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	@OneToMany(mappedBy = "video")
	private List<Favorite> favorites;
	
	@OneToMany(mappedBy = "video")
	private List<Share> shares;
	
	
}

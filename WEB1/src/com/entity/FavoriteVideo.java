package com.entity;

import java.util.Date;

public class FavoriteVideo {
	private Video video;
	private User user;
	private Favorite favorite;
	private String title;
	private String poster;
	private Integer views;
	private String description;
	private Integer active;
	private String link;
	private Date likeDate;

	public FavoriteVideo() {
		super();
	}

	@Override
	public String toString() {
		return "FavoriteVideo [video=" + video + ", user=" + user + ", favorite=" + favorite + ", title=" + title
				+ ", poster=" + poster + ", views=" + views + ", description=" + description + ", active=" + active
				+ ", link=" + link + ", likeDate=" + likeDate + "]";
	}

	public FavoriteVideo(Video video, User user, Favorite favorite, String title, String poster, Integer views,
			String description, Integer active, String link, Date likeDate) {
		super();
		this.video = video;
		this.user = user;
		this.favorite = favorite;
		this.title = title;
		this.poster = poster;
		this.views = views;
		this.description = description;
		this.active = active;
		this.link = link;
		this.likeDate = likeDate;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Favorite getFavorite() {
		return favorite;
	}

	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
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

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

}

package com.assignment.urlshortner.shorturl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.assignment.urlshortner.user.User;

@Entity
public class ShortURL {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int urlId;
	private String url;
	private String shortURL;
	private int clickCount;

	@ManyToOne
	private User user;

	public int getUrlId() {
		return urlId;
	}

	public void setUrlId(int urlId) {
		this.urlId = urlId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShortURL() {
		return shortURL;
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public int incremtClickCount(int x) {
		
		int ans = x + 1;
		return ans;
	}

}

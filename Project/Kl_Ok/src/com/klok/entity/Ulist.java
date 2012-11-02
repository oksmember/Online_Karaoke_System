package com.klok.entity;

/**
 * Ulist entity. @author MyEclipse Persistence Tools
 */

public class Ulist implements java.io.Serializable {

	// Fields

	private Integer lid;
	private User user;
	private Music music;

	// Constructors

	/** default constructor */
	public Ulist() {
	}

	/** full constructor */
	public Ulist(User user, Music music) {
		this.user = user;
		this.music = music;
	}

	// Property accessors

	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Music getMusic() {
		return this.music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

}
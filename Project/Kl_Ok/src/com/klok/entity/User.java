package com.klok.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String upwd;
	private Boolean aflag;
	private Set ulists = new HashSet(0);
	private Set details = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String uname, String upwd, Boolean aflag) {
		this.uname = uname;
		this.upwd = upwd;
		this.aflag = aflag;
	}

	/** full constructor */
	public User(String uname, String upwd, Boolean aflag, Set ulists,
			Set details) {
		this.uname = uname;
		this.upwd = upwd;
		this.aflag = aflag;
		this.ulists = ulists;
		this.details = details;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public Boolean getAflag() {
		return this.aflag;
	}

	public void setAflag(Boolean aflag) {
		this.aflag = aflag;
	}

	public Set getUlists() {
		return this.ulists;
	}

	public void setUlists(Set ulists) {
		this.ulists = ulists;
	}

	public Set getDetails() {
		return this.details;
	}

	public void setDetails(Set details) {
		this.details = details;
	}

}
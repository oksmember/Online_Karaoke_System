package com.klok.entity;

/**
 * Detail entity. @author MyEclipse Persistence Tools
 */

public class Detail implements java.io.Serializable {

	// Fields

	private Integer uid;
	private User user;
	private String dsex;
	private String dnname;
	private String demail;
	private String dpn;
	private String dlip;
	private String drip;

	// Constructors

	/** default constructor */
	public Detail() {
	}

	/** minimal constructor */
	public Detail(Integer uid, User user, String drip) {
		this.uid = uid;
		this.user = user;
		this.drip = drip;
	}

	/** full constructor */
	public Detail(Integer uid, User user, String dsex, String dnname,
			String demail, String dpn, String dlip, String drip) {
		this.uid = uid;
		this.user = user;
		this.dsex = dsex;
		this.dnname = dnname;
		this.demail = demail;
		this.dpn = dpn;
		this.dlip = dlip;
		this.drip = drip;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDsex() {
		return this.dsex;
	}

	public void setDsex(String dsex) {
		this.dsex = dsex;
	}

	public String getDnname() {
		return this.dnname;
	}

	public void setDnname(String dnname) {
		this.dnname = dnname;
	}

	public String getDemail() {
		return this.demail;
	}

	public void setDemail(String demail) {
		this.demail = demail;
	}

	public String getDpn() {
		return this.dpn;
	}

	public void setDpn(String dpn) {
		this.dpn = dpn;
	}

	public String getDlip() {
		return this.dlip;
	}

	public void setDlip(String dlip) {
		this.dlip = dlip;
	}

	public String getDrip() {
		return this.drip;
	}

	public void setDrip(String drip) {
		this.drip = drip;
	}

}
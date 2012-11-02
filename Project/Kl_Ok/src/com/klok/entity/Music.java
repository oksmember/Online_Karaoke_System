package com.klok.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Music entity. @author MyEclipse Persistence Tools
 */

public class Music implements java.io.Serializable {

	// Fields

	private Integer mid;
	private String mname;
	private String mfa;
	private String msa;
	private String mart;
	private String maum;
	private Integer my;
	private String mc;
	private Integer mt;
	private Boolean muflag;
	private Set ulists = new HashSet(0);

	// Constructors

	/** default constructor */
	public Music() {
	}

	/** minimal constructor */
	public Music(String mname, String mfa, String msa, Boolean muflag) {
		this.mname = mname;
		this.mfa = mfa;
		this.msa = msa;
		this.muflag = muflag;
	}

	/** full constructor */
	public Music(String mname, String mfa, String msa, String mart,
			String maum, Integer my, String mc, Integer mt, Boolean muflag,
			Set ulists) {
		this.mname = mname;
		this.mfa = mfa;
		this.msa = msa;
		this.mart = mart;
		this.maum = maum;
		this.my = my;
		this.mc = mc;
		this.mt = mt;
		this.muflag = muflag;
		this.ulists = ulists;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMfa() {
		return this.mfa;
	}

	public void setMfa(String mfa) {
		this.mfa = mfa;
	}

	public String getMsa() {
		return this.msa;
	}

	public void setMsa(String msa) {
		this.msa = msa;
	}

	public String getMart() {
		return this.mart;
	}

	public void setMart(String mart) {
		this.mart = mart;
	}

	public String getMaum() {
		return this.maum;
	}

	public void setMaum(String maum) {
		this.maum = maum;
	}

	public Integer getMy() {
		return this.my;
	}

	public void setMy(Integer my) {
		this.my = my;
	}

	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public Integer getMt() {
		return this.mt;
	}

	public void setMt(Integer mt) {
		this.mt = mt;
	}

	public Boolean getMuflag() {
		return this.muflag;
	}

	public void setMuflag(Boolean muflag) {
		this.muflag = muflag;
	}

	public Set getUlists() {
		return this.ulists;
	}

	public void setUlists(Set ulists) {
		this.ulists = ulists;
	}

}
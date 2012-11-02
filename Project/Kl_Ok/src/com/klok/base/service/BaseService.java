package com.klok.base.service;

import org.apache.log4j.Logger;

import com.klok.DAO.*;


public class BaseService {
	private IDetailDAO detailDAO;
	private IMusicDAO musicDAO;
	private IUlistDAO ulistDAO;
	private IUserDAO userDAO;
	public IDetailDAO getDetailDAO() {
		return detailDAO;
	}
	public void setDetailDAO(IDetailDAO detailDAO) {
		this.detailDAO = detailDAO;
	}
	public IMusicDAO getMusicDAO() {
		return musicDAO;
	}
	public void setMusicDAO(IMusicDAO musicDAO) {
		this.musicDAO = musicDAO;
	}
	public IUlistDAO getUlistDAO() {
		return ulistDAO;
	}
	public void setUlistDAO(IUlistDAO ulistDAO) {
		this.ulistDAO = ulistDAO;
	}
	public IUserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
}

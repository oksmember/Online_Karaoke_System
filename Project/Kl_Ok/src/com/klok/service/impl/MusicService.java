package com.klok.service.impl;

import java.util.List;

import com.klok.base.service.BaseService;
import com.klok.entity.Music;
import com.klok.service.IMusicService;

public class MusicService extends BaseService implements IMusicService {

	@Override
	public List getAllMusic() {
		// TODO Auto-generated method stub
		return this.getMusicDAO().findAll();
	}

	@Override
	public Music getMusicById(int id) {
		// TODO Auto-generated method stub
		return this.getMusicDAO().findById(id);
	}

	@Override
	public List getMusic(int flag, String search) {
		// TODO Auto-generated method stub
		switch(flag){
		case 1:
			return this.getMusicDAO().findByMname(search);
		case 2:
			return this.getMusicDAO().findByMart(search);
		case 3:
			return this.getMusicDAO().findByMaum(search);
		default:
			return null;
		}
	}

	@Override
	public void saveMusic(Music music) {
		// TODO Auto-generated method stub
		this.getMusicDAO().save(music);
	}

	@Override
	public void changeMusic(Music music) {
		// TODO Auto-generated method stub
		this.getMusicDAO().merge(music);
	}

	@Override
	public void deleteMusic(Music music) {
		// TODO Auto-generated method stub
		this.getMusicDAO().delete(music);
	}
	
}

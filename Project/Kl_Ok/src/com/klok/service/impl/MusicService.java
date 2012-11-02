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
	
}

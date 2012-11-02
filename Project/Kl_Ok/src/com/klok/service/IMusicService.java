package com.klok.service;

import java.util.List;

import com.klok.entity.Music;

public interface IMusicService {
	public List getAllMusic();
	public Music getMusicById(int id);
}

package com.klok.service;

import java.util.List;

import com.klok.entity.Music;

public interface IMusicService {
	public List getAllMusic();
	public Music getMusicById(int id);
	public List getMusic(int flag,String search);
	public void saveMusic(Music music);
	public void changeMusic(Music music);
	public void deleteMusic(Music music);
}

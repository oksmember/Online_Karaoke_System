package com.klok.action;

import java.util.*;

import org.apache.struts2.ServletActionContext;

import com.klok.base.action.BaseAction;
import com.klok.entity.Music;
import com.klok.service.IMusicService;
import com.klok.util.LrcInfo;
import com.klok.util.LrcParser;

public class MusicAction extends BaseAction {
	private static final long serialVersionUID = 434558394566262120L;
	
	private IMusicService musicService;
	private List musicList;
	private LrcInfo lrcinfo;
	private Music music;
	
	public String forMusicList(){
		this.musicList=this.getMusicService().getAllMusic();
		this.setDynamicUrl("/right.jsp");
		return this.DYNAMIC;
	}
	
	public String playMusic(){
		this.music=this.getMusicService().getMusicById(music.getMid());
		try {
			this.lrcinfo=LrcParser.parser(ServletActionContext.getServletContext().getRealPath("/"+music.getMsa()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDynamicUrl("/main.jsp");
		return this.DYNAMIC;
	}

	public IMusicService getMusicService() {
		return musicService;
	}
	public void setMusicService(IMusicService musicService) {
		this.musicService = musicService;
	}
	public List getMusicList() {
		return musicList;
	}
	public void setMusicList(List musicList) {
		this.musicList = musicList;
	}
	public LrcInfo getLrcinfo() {
		return lrcinfo;
	}
	public void setLrcinfo(LrcInfo lrcinfo) {
		this.lrcinfo = lrcinfo;
	}
	public Music getMusic() {
		return music;
	}
	public void setMusic(Music music) {
		this.music = music;
	}
}

package com.klok.util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class LrcInfo {
    private String title;//歌曲名
	private String singer;//演唱者
	private String album;//专辑	
	private List<Double> time=new ArrayList<Double>();
	private List<String> lrc=new ArrayList<String>();
   //以下为getter()  setter()
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public List<Double> getTime() {
		return time;
	}
	public void setTime(List<Double> time) {
		this.time = time;
	}
	public List<String> getLrc() {
		return lrc;
	}
	public void setLrc(List<String> lrc) {
		this.lrc = lrc;
	}
}

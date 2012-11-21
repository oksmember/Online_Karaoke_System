package com.klok.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.klok.base.action.BaseAction;
import com.klok.entity.Music;
import com.klok.entity.Ulist;
import com.klok.entity.User;
import com.klok.service.IMusicService;
import com.klok.service.IUlistService;

public class UlistAction extends BaseAction {
	private static final long serialVersionUID = -5652997917267697949L;

	private IUlistService ulistService;
	private IMusicService musicService;
	private Music music;
	private List<Ulist> ulist;
	private Ulist listItem;
	private int num;
	private int id;
	private int flag;

	public String addToList(){
		flag=0;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		music=musicService.getMusicById(music.getMid());
		Ulist list=new Ulist();
		list.setMusic(music);
		User user=(User) session.getAttribute("user");
		list.setUser(user);
		ulist=this.ulistService.getListByUserId(user);
		list.setNo(ulist.size()+1);
		this.ulistService.save(list);
		flag=1;
		return "ajax";
	}

	public String forPlayList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		User user=(User) session.getAttribute("user");
		ulist=this.ulistService.getListByUserId(user);
		num=ulist.size();
		if(ulist.size()>0){
			id=ulist.get(0).getLid();
			music=ulist.get(0).getMusic();
			ulist.remove(0);
		}
		this.setDynamicUrl("/playlist.jsp");
		return this.DYNAMIC;
	}
	
	public String upToList(){
		flag=0;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		User user=(User) session.getAttribute("user");
		this.getUlistService().upChangeList(user);
		music=musicService.getMusicById(music.getMid());
		Ulist list=new Ulist();
		list.setMusic(music);
		list.setUser(user);
		ulist=this.ulistService.getListByUserId(user);
		list.setNo(1);
		this.ulistService.save(list);
		flag=1;
		return "ajax";
	}
	
	public String upList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		User user=(User) session.getAttribute("user");
		music=musicService.getMusicById(music.getMid());
		listItem=this.ulistService.getSingerUlist(user, listItem.getNo());
		listItem.setNo(1);
		this.ulistService.upList(user, listItem);
		this.setDynamicUrl("Ulist_forPlayList.action");
		return this.MYREDIRCT;
	}
	
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		User user=(User) session.getAttribute("user");
		this.ulistService.delete(user, listItem.getLid());
		this.setDynamicUrl("Ulist_forPlayList.action");
		return this.MYREDIRCT;
	}

	@JSON(serialize=false)
	public IUlistService getUlistService() {
		return ulistService;
	}
	public void setUlistService(IUlistService ulistService) {
		this.ulistService = ulistService;
	}
	public List getUlist() {
		return ulist;
	}
	public void setUlist(List ulist) {
		this.ulist = ulist;
	}
	public Music getMusic() {
		return music;
	}
	public void setMusic(Music music) {
		this.music = music;
	}
	@JSON(serialize=false)
	public IMusicService getMusicService() {
		return musicService;
	}
	public void setMusicService(IMusicService musicService) {
		this.musicService = musicService;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Ulist getListItem() {
		return listItem;
	}
	public void setListItem(Ulist listItem) {
		this.listItem = listItem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

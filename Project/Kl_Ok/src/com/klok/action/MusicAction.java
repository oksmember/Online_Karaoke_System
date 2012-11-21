package com.klok.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.klok.base.action.BaseAction;
import com.klok.entity.Music;
import com.klok.entity.Ulist;
import com.klok.entity.User;
import com.klok.service.IMusicService;
import com.klok.service.IUlistService;
import com.klok.util.LrcInfo;
import com.klok.util.LrcParser;

public class MusicAction extends BaseAction {
	private static final long serialVersionUID = 434558394566262120L;
	
	private IMusicService musicService;
	private IUlistService ulistService;
	private List musicList;
	private LrcInfo lrcinfo;
	private Music music;
	private List ulist;
	private User user;
	private String search;
	private int flag;
	
    private File file;
    private String fileFileName;
    private String fileContentType;
	
	public String forMusicList(){
		this.musicList=this.getMusicService().getAllMusic();
		this.setDynamicUrl("/right.jsp");
		return this.DYNAMIC;
	}
	
	public String forUserMusicList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		this.musicList=this.getMusicService().getAllMusic();
		user=(User) session.getAttribute("user");
		ulist=this.getUlistService().getListByUserId(user);
		this.setDynamicUrl("/right2.jsp");
		return this.DYNAMIC;
	}
	
	public String forGMMusicList(){
		this.musicList=this.getMusicService().getAllMusic();
		this.setDynamicUrl("/manage_index.jsp");
		return this.DYNAMIC;
	}
	
	public String playMusic(){
		this.music=this.getMusicService().getMusicById(music.getMid());
		LrcParser parser=new LrcParser();
		try {
			this.lrcinfo=parser.parser(ServletActionContext.getServletContext().getRealPath("/"+music.getMsa()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDynamicUrl("/main.jsp");
		return this.DYNAMIC;
	}

	public String startPlay(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		user=(User) session.getAttribute("user");
		List<Ulist> list=this.getUlistService().getListByUserId(user);
		music=list.get(0).getMusic();
		this.getUlistService().changeNextList(user);
		this.setDynamicUrl("/Music_playMusic?music.mid="+music.getMid());
		return this.MYREDIRCT;
	}
	
	public String nextPlay(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		user=(User) session.getAttribute("user");
		List<Ulist> list=this.getUlistService().getListByUserId(user);
		music=list.get(1).getMusic();
		this.setDynamicUrl("/main.jsp");
		return this.DYNAMIC;
	}
	
	public String noUserSearch(){
		musicList=this.musicService.getMusic(flag, search);
		this.setDynamicUrl("/right.jsp");
		return this.DYNAMIC;
	}

	public String userSearch(){
		musicList=this.musicService.getMusic(flag, search);
		this.setDynamicUrl("/right2.jsp");
		return this.DYNAMIC;
	}
	
	public String upMusic() {
        // 实现上传
        String root = ServletActionContext.getRequest().getRealPath("/music");
        InputStream is;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		String[] type=fileFileName.split("\\.");
		String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		fileFileName="m"+time+"."+type[type.length-1];
		session.setAttribute("mfa", fileFileName);
		try {
			is = new FileInputStream(file);
	        File deskFile = new File(root, this.getFileFileName());
	        OutputStream os = new FileOutputStream(deskFile);
	        byte[] bytefer = new byte[1024];
	        int length = 0;
	        while ((length = is.read(bytefer)) != -1) {
	            os.write(bytefer, 0, length);
	        }
	        os.close();
	        is.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDynamicUrl("/manage_index.jsp");
		return this.DYNAMIC;
    }
	
	public String upLrc() {
        // 实现上传
        String root = ServletActionContext.getRequest().getRealPath("/lrc");
        InputStream is;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		String[] type=fileFileName.split("\\.");
		String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		fileFileName="l"+time+"."+type[type.length-1];
		session.setAttribute("msa", fileFileName);
		try {
			is = new FileInputStream(file);
	        File deskFile = new File(root, this.getFileFileName());
	        OutputStream os = new FileOutputStream(deskFile);
	        byte[] bytefer = new byte[1024];
	        int length = 0;
	        while ((length = is.read(bytefer)) != -1) {
	            os.write(bytefer, 0, length);
	        }
	        os.close();
	        is.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDynamicUrl("/manage_index.jsp");
		return this.DYNAMIC;
    }
	
	public String addMusic(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		music.setMfa("music/"+session.getAttribute("mfa"));
		music.setMsa("lrc/"+session.getAttribute("msa"));
		music.setMt(0);
		if(flag==0)
			music.setMuflag(false);
		else
			music.setMuflag(true);
		this.musicService.saveMusic(music);
		session.removeAttribute("mfa");
		session.removeAttribute("msa");
		this.setDynamicUrl("Music_forGMMusicList.action");
		return this.MYREDIRCT;
	}
	
	public String forChangeMusic(){
		music=this.musicService.getMusicById(music.getMid());
		if(music.getMuflag()){
			flag=1;
		}
		else
			flag=0;
		this.setDynamicUrl("/changeinfo.jsp");
		return this.DYNAMIC;
	}
	
	public String changeMusic(){
		Music m=this.musicService.getMusicById(music.getMid());
		music.setMsa(m.getMsa());
		music.setMfa(m.getMfa());
		music.setMt(m.getMt());
		if(flag==0)
			music.setMuflag(false);
		else
			music.setMuflag(true);
		this.musicService.changeMusic(music);
		this.setDynamicUrl("Music_forGMMusicList.action");
		return this.MYREDIRCT;
	}
	
	public String deleteMusic(){
		music=this.musicService.getMusicById(music.getMid());
		File file = new File(ServletActionContext.getRequest().getRealPath("/"+music.getMfa()));
		if(file.isFile() && file.exists()) file.delete();   
		file = new File(ServletActionContext.getRequest().getRealPath("/"+music.getMsa()));
		if(file.isFile() && file.exists()) file.delete(); 
		this.getMusicService().deleteMusic(music);
		this.setDynamicUrl("Music_forGMMusicList.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * get&set
	 * @return
	 */
	public IMusicService getMusicService() {
		return musicService;
	}
	public void setMusicService(IMusicService musicService) {
		this.musicService = musicService;
	}
	public IUlistService getUlistService() {
		return ulistService;
	}
	public void setUlistService(IUlistService ulistService) {
		this.ulistService = ulistService;
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
	public List getUList() {
		return ulist;
	}
	public void setUList(List uList) {
		ulist = uList;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}

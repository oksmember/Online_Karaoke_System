package com.klok.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.klok.base.action.BaseAction;
import com.klok.entity.User;
import com.klok.service.IUserService;

public class UserAction extends BaseAction {
	private static final long serialVersionUID = 3418930074519875935L;
	private IUserService userService;
	private User user;

	public String Login(){
		int flag=this.userService.login(user);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		if(flag>0){
			user=this.userService.getUserByName(user.getUname());
			session.setAttribute("user", user);
			if(flag==1){
				this.setDynamicUrl("/Music_forUserMusicList.action");
				return this.MYREDIRCT;
			}
			else{
				this.setDynamicUrl("/error.jsp");
				return this.MYREDIRCT;
			}
		}
		else{
			this.setDynamicUrl("/error.jsp");
			return this.DYNAMIC;
		}
	}
	
	public String GMLogin(){
		int flag=this.userService.login(user);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		if(flag>0){
			user=this.userService.getUserByName(user.getUname());
			session.setAttribute("user", user);
			if(flag==2){
				this.setDynamicUrl("/Music_forGMMusicList.action");
				return this.MYREDIRCT;
			}
			else{
				this.setDynamicUrl("/GMerror.jsp");
				return this.MYREDIRCT;
			}
		}
		else{
			this.setDynamicUrl("/GMerror.jsp");
			return this.DYNAMIC;
		}
	}

	/**
	 * get&set
	 * @return
	 */
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

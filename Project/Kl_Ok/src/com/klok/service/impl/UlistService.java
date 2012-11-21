package com.klok.service.impl;

import java.util.List;

import com.klok.base.service.BaseService;
import com.klok.entity.Ulist;
import com.klok.entity.User;
import com.klok.service.IUlistService;

public class UlistService extends BaseService implements IUlistService {

	@Override
	public void save(Ulist ulist) {
		// TODO Auto-generated method stub
		this.getUlistDAO().save(ulist);
	}

	@Override
	public List getListByUserId(User user) {
		// TODO Auto-generated method stub
		return this.getUlistDAO().findByProperty("user", user);
	}

	@Override
	public void changeNextList(User user) {
		// TODO Auto-generated method stub
		List<Ulist> list=this.getUlistDAO().findByProperty("user", user);
		Ulist item=list.get(0);
		this.getUlistDAO().delete(item);
		list.remove(0);
		for(Ulist u:list){
			u.setNo(u.getNo()-1);
			this.getUlistDAO().merge(u);
		}
	}

	@Override
	public void upChangeList(User user) {
		// TODO Auto-generated method stub
		List<Ulist> list=this.getUlistDAO().findByProperty("user", user);
		for(Ulist u:list){
			u.setNo(u.getNo()+1);
			this.getUlistDAO().merge(u);
		}
	}

	@Override
	public void upList(User user, Ulist list) {
		// TODO Auto-generated method stub
		List<Ulist> ulist=this.getUlistDAO().findByProperty("user", user);
		for(Ulist u:ulist){
			u.setNo(u.getNo()+1);
			this.getUlistDAO().merge(u);
		}
		this.getUlistDAO().merge(list);
	}

	@Override
	public Ulist getSingerUlist(User user, int no) {
		// TODO Auto-generated method stub
		List<Ulist> list=this.getUlistDAO().findByProperty("user", user);
		return list.get(no-1);
	}

	@Override
	public void delete(User user, int id) {
		// TODO Auto-generated method stub
		Ulist item=this.getUlistDAO().findById(id);
		List<Ulist> list=this.getUlistDAO().findByProperty("user", user);
		for(int i=item.getNo();i<list.size();i++){
			Ulist nitem=list.get(i);
			nitem.setNo(nitem.getNo()-1);
			this.getUlistDAO().merge(nitem);
		}
		this.getUlistDAO().delete(item);
	}
}

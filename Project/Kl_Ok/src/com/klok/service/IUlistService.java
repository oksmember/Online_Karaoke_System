package com.klok.service;

import java.util.List;

import com.klok.entity.Ulist;
import com.klok.entity.User;

public interface IUlistService {
	public void save(Ulist ulist);
	public List getListByUserId(User user);
	public void changeNextList(User user);
	public void upChangeList(User user);
	public void upList(User user, Ulist list);
	public Ulist getSingerUlist(User user, int no);
	public void delete(User user, int id);
}

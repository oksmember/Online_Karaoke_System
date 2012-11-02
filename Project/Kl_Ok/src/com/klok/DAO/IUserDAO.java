package com.klok.DAO;

import java.util.List;

import com.klok.entity.User;

public interface IUserDAO {

	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);

	public abstract User findById(java.lang.Integer id);

	public abstract List findByExample(User instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUname(Object uname);

	public abstract List findByUpwd(Object upwd);

	public abstract List findByAflag(Object aflag);

	public abstract List findAll();

	public abstract User merge(User detachedInstance);

	public abstract void attachDirty(User instance);

	public abstract void attachClean(User instance);

}
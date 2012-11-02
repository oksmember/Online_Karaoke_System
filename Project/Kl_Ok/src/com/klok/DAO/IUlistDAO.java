package com.klok.DAO;

import java.util.List;

import com.klok.entity.Ulist;

public interface IUlistDAO {

	public abstract void save(Ulist transientInstance);

	public abstract void delete(Ulist persistentInstance);

	public abstract Ulist findById(java.lang.Integer id);

	public abstract List findByExample(Ulist instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Ulist merge(Ulist detachedInstance);

	public abstract void attachDirty(Ulist instance);

	public abstract void attachClean(Ulist instance);

}
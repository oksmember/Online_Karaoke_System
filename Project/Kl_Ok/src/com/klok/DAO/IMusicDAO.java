package com.klok.DAO;

import java.util.List;

import com.klok.entity.Music;

public interface IMusicDAO {

	public abstract void save(Music transientInstance);

	public abstract void delete(Music persistentInstance);

	public abstract Music findById(java.lang.Integer id);

	public abstract List findByExample(Music instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByMname(Object mname);

	public abstract List findByMfa(Object mfa);

	public abstract List findByMsa(Object msa);

	public abstract List findByMart(Object mart);

	public abstract List findByMaum(Object maum);

	public abstract List findByMy(Object my);

	public abstract List findByMc(Object mc);

	public abstract List findByMt(Object mt);

	public abstract List findByMuflag(Object muflag);

	public abstract List findAll();

	public abstract Music merge(Music detachedInstance);

	public abstract void attachDirty(Music instance);

	public abstract void attachClean(Music instance);

}
package com.klok.DAO;

import java.util.List;

import com.klok.entity.Detail;

public interface IDetailDAO {

	public abstract void save(Detail transientInstance);

	public abstract void delete(Detail persistentInstance);

	public abstract Detail findById(java.lang.Integer id);

	public abstract List findByExample(Detail instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByDsex(Object dsex);

	public abstract List findByDnname(Object dnname);

	public abstract List findByDemail(Object demail);

	public abstract List findByDpn(Object dpn);

	public abstract List findByDlip(Object dlip);

	public abstract List findByDrip(Object drip);

	public abstract List findAll();

	public abstract Detail merge(Detail detachedInstance);

	public abstract void attachDirty(Detail instance);

	public abstract void attachClean(Detail instance);

}
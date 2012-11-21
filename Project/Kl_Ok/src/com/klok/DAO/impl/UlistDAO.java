package com.klok.DAO.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.klok.DAO.IUlistDAO;
import com.klok.entity.Ulist;

/**
 * A data access object (DAO) providing persistence and search support for Ulist
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.klok.entity.Ulist
 * @author MyEclipse Persistence Tools
 */

public class UlistDAO extends HibernateDaoSupport implements IUlistDAO {
	private static final Logger log = LoggerFactory.getLogger(UlistDAO.class);
	// property constants
	public static final String NO = "no";

	protected void initDao() {
		// do nothing
	}

	public void save(Ulist transientInstance) {
		log.debug("saving Ulist instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ulist persistentInstance) {
		log.debug("deleting Ulist instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ulist findById(java.lang.Integer id) {
		log.debug("getting Ulist instance with id: " + id);
		try {
			Ulist instance = (Ulist) getHibernateTemplate().get(
					"com.klok.entity.Ulist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Ulist instance) {
		log.debug("finding Ulist instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.info("finding Ulist instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ulist as model where model."
					+ propertyName + "= ? order by model.no";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNo(Object no) {
		return findByProperty(NO, no);
	}

	public List findAll() {
		log.debug("finding all Ulist instances");
		try {
			String queryString = "from Ulist";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Ulist merge(Ulist detachedInstance) {
		log.debug("merging Ulist instance");
		try {
			Ulist result = (Ulist) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ulist instance) {
		log.debug("attaching dirty Ulist instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ulist instance) {
		log.debug("attaching clean Ulist instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UlistDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UlistDAO) ctx.getBean("UlistDAO");
	}
}
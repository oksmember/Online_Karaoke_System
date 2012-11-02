package com.klok.DAO.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.klok.DAO.IDetailDAO;
import com.klok.entity.Detail;

/**
 * A data access object (DAO) providing persistence and search support for
 * Detail entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.klok.entity.Detail
 * @author MyEclipse Persistence Tools
 */

public class DetailDAO extends HibernateDaoSupport implements IDetailDAO {
	private static final Logger log = LoggerFactory.getLogger(DetailDAO.class);
	// property constants
	public static final String DSEX = "dsex";
	public static final String DNNAME = "dnname";
	public static final String DEMAIL = "demail";
	public static final String DPN = "dpn";
	public static final String DLIP = "dlip";
	public static final String DRIP = "drip";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#save(com.klok.entity.Detail)
	 */
	@Override
	public void save(Detail transientInstance) {
		log.debug("saving Detail instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#delete(com.klok.entity.Detail)
	 */
	@Override
	public void delete(Detail persistentInstance) {
		log.debug("deleting Detail instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#findById(java.lang.Integer)
	 */
	@Override
	public Detail findById(java.lang.Integer id) {
		log.debug("getting Detail instance with id: " + id);
		try {
			Detail instance = (Detail) getHibernateTemplate().get(
					"com.klok.entity.Detail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#findByExample(com.klok.entity.Detail)
	 */
	@Override
	public List findByExample(Detail instance) {
		log.debug("finding Detail instance by example");
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

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Detail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Detail as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#findByDsex(java.lang.Object)
	 */
	@Override
	public List findByDsex(Object dsex) {
		return findByProperty(DSEX, dsex);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#findByDnname(java.lang.Object)
	 */
	@Override
	public List findByDnname(Object dnname) {
		return findByProperty(DNNAME, dnname);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#findByDemail(java.lang.Object)
	 */
	@Override
	public List findByDemail(Object demail) {
		return findByProperty(DEMAIL, demail);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#findByDpn(java.lang.Object)
	 */
	@Override
	public List findByDpn(Object dpn) {
		return findByProperty(DPN, dpn);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#findByDlip(java.lang.Object)
	 */
	@Override
	public List findByDlip(Object dlip) {
		return findByProperty(DLIP, dlip);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#findByDrip(java.lang.Object)
	 */
	@Override
	public List findByDrip(Object drip) {
		return findByProperty(DRIP, drip);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Detail instances");
		try {
			String queryString = "from Detail";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#merge(com.klok.entity.Detail)
	 */
	@Override
	public Detail merge(Detail detachedInstance) {
		log.debug("merging Detail instance");
		try {
			Detail result = (Detail) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#attachDirty(com.klok.entity.Detail)
	 */
	@Override
	public void attachDirty(Detail instance) {
		log.debug("attaching dirty Detail instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IDetailDAO#attachClean(com.klok.entity.Detail)
	 */
	@Override
	public void attachClean(Detail instance) {
		log.debug("attaching clean Detail instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IDetailDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IDetailDAO) ctx.getBean("DetailDAO");
	}
}
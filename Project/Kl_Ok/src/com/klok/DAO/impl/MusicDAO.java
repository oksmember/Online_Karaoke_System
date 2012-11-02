package com.klok.DAO.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.klok.DAO.IMusicDAO;
import com.klok.entity.Music;

/**
 * A data access object (DAO) providing persistence and search support for Music
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.klok.entity.Music
 * @author MyEclipse Persistence Tools
 */

public class MusicDAO extends HibernateDaoSupport implements IMusicDAO {
	private static final Logger log = LoggerFactory.getLogger(MusicDAO.class);
	// property constants
	public static final String MNAME = "mname";
	public static final String MFA = "mfa";
	public static final String MSA = "msa";
	public static final String MART = "mart";
	public static final String MAUM = "maum";
	public static final String MY = "my";
	public static final String MC = "mc";
	public static final String MT = "mt";
	public static final String MUFLAG = "muflag";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#save(com.klok.entity.Music)
	 */
	@Override
	public void save(Music transientInstance) {
		log.debug("saving Music instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#delete(com.klok.entity.Music)
	 */
	@Override
	public void delete(Music persistentInstance) {
		log.debug("deleting Music instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#findById(java.lang.Integer)
	 */
	@Override
	public Music findById(java.lang.Integer id) {
		log.debug("getting Music instance with id: " + id);
		try {
			Music instance = (Music) getHibernateTemplate().get(
					"com.klok.entity.Music", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#findByExample(com.klok.entity.Music)
	 */
	@Override
	public List findByExample(Music instance) {
		log.debug("finding Music instance by example");
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
	 * @see com.klok.DAO.impl.IMusicDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Music instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Music as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#findByMname(java.lang.Object)
	 */
	@Override
	public List findByMname(Object mname) {
		return findByProperty(MNAME, mname);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#findByMfa(java.lang.Object)
	 */
	@Override
	public List findByMfa(Object mfa) {
		return findByProperty(MFA, mfa);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#findByMsa(java.lang.Object)
	 */
	@Override
	public List findByMsa(Object msa) {
		return findByProperty(MSA, msa);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#findByMart(java.lang.Object)
	 */
	@Override
	public List findByMart(Object mart) {
		return findByProperty(MART, mart);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#findByMaum(java.lang.Object)
	 */
	@Override
	public List findByMaum(Object maum) {
		return findByProperty(MAUM, maum);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#findByMy(java.lang.Object)
	 */
	@Override
	public List findByMy(Object my) {
		return findByProperty(MY, my);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#findByMc(java.lang.Object)
	 */
	@Override
	public List findByMc(Object mc) {
		return findByProperty(MC, mc);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#findByMt(java.lang.Object)
	 */
	@Override
	public List findByMt(Object mt) {
		return findByProperty(MT, mt);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#findByMuflag(java.lang.Object)
	 */
	@Override
	public List findByMuflag(Object muflag) {
		return findByProperty(MUFLAG, muflag);
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Music instances");
		try {
			String queryString = "from Music";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#merge(com.klok.entity.Music)
	 */
	@Override
	public Music merge(Music detachedInstance) {
		log.debug("merging Music instance");
		try {
			Music result = (Music) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#attachDirty(com.klok.entity.Music)
	 */
	@Override
	public void attachDirty(Music instance) {
		log.debug("attaching dirty Music instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IMusicDAO#attachClean(com.klok.entity.Music)
	 */
	@Override
	public void attachClean(Music instance) {
		log.debug("attaching clean Music instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IMusicDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IMusicDAO) ctx.getBean("MusicDAO");
	}
}
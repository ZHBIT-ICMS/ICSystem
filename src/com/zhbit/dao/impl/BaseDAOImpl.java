package com.zhbit.dao.impl;

import com.zhbit.entity.base.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zhbit.dao.BaseDAO;

import java.io.Serializable;
import java.util.List;

@Repository("baseDAO")
@SuppressWarnings("all")
public class BaseDAOImpl<T> implements BaseDAO<T> {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 保存
	 * @param o
	 * @return
	 */
	public Serializable save(T o) {
		return this.getCurrentSession().save(o);
	}

	/**
	 * 删除
	 * @param o
	 */
	public void delete(T o) {
		this.getCurrentSession().delete(o);
	}

	/**
	 * 更新
	 * @param o
	 */
	public void update(T o) {
		this.getCurrentSession().update(o);
	}

	/**
	 * 保存&更新
	 * @param o
	 */
	public void saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
	}

	/**
	 * 带hql语句的查询
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql) {
		return this.getCurrentSession().createQuery(hql).list();
	}

	/**
	 * 带sql&参数的查询
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	/**
	 * 带sql&参数(集合)的查询
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	/**
	 * 带sql&参数的查询&附加上分页
	 * @param hql
	 * @param param
	 * @param pageBean
	 * @return
	 */
	public List<T> find(String hql, Object[] param, PageBean pageBean) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult(pageBean.getStart()).setMaxResults(pageBean.getPageSize()).list();
	}

	/**
	 * 带sql&参数(集合)的查询&附加上分页
	 * @param hql
	 * @param param
	 * @param pageBean
	 * @return
	 */
	public List<T> find(String hql, List<Object> param, PageBean pageBean) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult(pageBean.getStart()).setMaxResults(pageBean.getPageSize()).list();
	}

	/**
	 * 获取一条记录
	 * @param c
	 * @param id
	 * @return
	 */
	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 获取一条记录带参
	 * @param hql
	 * @param param
	 * @return
	 */
	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 获取总的记录数
	 * @param hql
	 * @return
	 */
	public Long count(String hql) {
		return  (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
	}

	public Long count(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}

	/**
	 *  获取总的记录数带参数
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	/**
	 * 执行hql语句
	 * @param hql
	 * @return
	 */
	public Integer executeHql(String hql) {
		return this.getCurrentSession().createQuery(hql).executeUpdate();
	}

	public Integer executeHql(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	/**
	 * 执行带参数的hql语句
	 * @param hql
	 * @param param
	 * @return
	 */
	public Integer executeHql(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}

	/**
	 * 合并
	 * @param o
	 */
	public void merge(T o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().merge(o);
	}

	/**
	 * 实行sql语句
	 * @param sql
	 * @return
	 */
	public Integer executeSql(String sql) {
		Query q = this.getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

}

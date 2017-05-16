package com.twinflag.web.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl<T, PK extends Serializable> implements IBaseDao<T, PK> {
	
	@Resource
	protected SessionFactory sessionFactory;
	
	private Class<T> entityClass;
	
	public BaseDaoImpl() {
		this.entityClass = null;
		Class<?> c = getClass();
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] types = ((ParameterizedType)type).getActualTypeArguments();
			this.entityClass = (Class<T>) types[0];
		}
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public T get(PK id) {
		return (T)getSession().get(entityClass, id);
	}

	public PK save(T entity) {
		return (PK)getSession().save(entity);
	}

}

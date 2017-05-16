package com.twinflag.web.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twinflag.web.dao.IBaseDao;

@Transactional
@Service
public class BaseServiceImpl<T, PK extends Serializable> implements IBaseService<T, PK>{
	
	@Autowired
	private IBaseDao<T, PK> baseDao;
	
	public T get(PK id) {
		return baseDao.get(id);
	}

	public PK save(T entity) {
		return baseDao.save(entity);
	}
	
}

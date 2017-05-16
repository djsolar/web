package com.twinflag.web.dao;

import java.io.Serializable;

public interface IBaseDao<T, PK extends Serializable>{
	
	
	T get(PK id);
	
	PK save(T entity);
}

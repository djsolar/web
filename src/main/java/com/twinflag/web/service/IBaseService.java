package com.twinflag.web.service;

import java.io.Serializable;

public interface IBaseService<T, PK extends Serializable> {
	
	T get(PK id);
	
	PK save(T entity);
}

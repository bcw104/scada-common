package com.ht.scada.common.tag.service;

public interface BaseService<T> {
	
	public void create(T domain);
	
	public void deleteById(int id);
	
	public void update(T domain);
	
	public T getById(int id);

}

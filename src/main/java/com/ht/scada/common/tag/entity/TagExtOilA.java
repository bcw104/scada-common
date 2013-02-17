package com.ht.scada.common.tag.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="T_Tag_Ext_OilA")
public class TagExtOilA extends AbstractPersistable<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2707445505322556394L;

	@Column(name="beng_jing")
	private String bengJing;//泵径
	
	private String username;
	
	public TagExtOilA() {
	}
	
	public TagExtOilA(int id) {
		setId(id);
	}

	public String getBengJing() {
		return bengJing;
	}

	public void setBengJing(String bengJing) {
		this.bengJing = bengJing;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

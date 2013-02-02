package com.ht.scada.common.tag.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="T_Tag_Ext_OilA")
public class TagExtOilA extends AbstractPersistable<Integer> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5246876663144724507L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="beng_jing")
	private String bengJing;//泵径
	
	private String username;

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

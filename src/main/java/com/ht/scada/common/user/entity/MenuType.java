package com.ht.scada.common.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
@Table(name="T_MenuType")
public class MenuType extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8285880401907156684L;
	
	@Column(nullable=false, unique=true)
	private String menuTypeName;
	
	public String getMenuTypeName() {
		return menuTypeName;
	}
	public void setMenuTypeName(String menuTypeName) {
		this.menuTypeName = menuTypeName;
	}
	
}

package com.ht.scada.common.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_MenuItem")
public class MenuItem extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5473548079509300042L;


	@Column(nullable=false)
	private String menuItemName;
	
	@Column(nullable=false)
	private String menuItemUrl;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="type_id")
        @JsonIgnore
	private MenuType menuType;

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public String getMenuItemUrl() {
		return menuItemUrl;
	}

	public void setMenuItemUrl(String menuItemUrl) {
		this.menuItemUrl = menuItemUrl;
	}

	public MenuType getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}
	
	

}

package com.ht.scada.common.user.entity;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "T_User_Role ")
public class UserRole extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7614412905280452693L;

	@Basic(optional = false)
	@Column(length = 100)
	@Index(name = "idx_roles_name")
	private String name;

	@Basic(optional = false)
	@Column(length = 255)
	private String description;

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "T_Roles_Permissions")
	@Column(name = "permissions")
	private Set<String> permissions;// user:edit,user:add

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

}

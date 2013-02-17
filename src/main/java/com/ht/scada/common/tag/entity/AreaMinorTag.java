package com.ht.scada.common.tag.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 分区次索引节点
 * @author user
 *
 */
@Entity
@Table(name="T_Area_Minor_Tag")
public class AreaMinorTag extends AbstractPersistable<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5534702454112581237L;
	private String name;// 名称
	private String type;// 类型或编号
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private AreaMinorTag parent;
	
	@OneToMany(mappedBy="parent")
	private List<AreaMinorTag> children;
	
	/*非持久化字段*/
	@Transient
	private String path;
	
	

	public AreaMinorTag() {
	}
	
	public AreaMinorTag(int id) {
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AreaMinorTag getParent() {
		return parent;
	}

	public void setParent(AreaMinorTag parent) {
		this.parent = parent;
	}

	public List<AreaMinorTag> getChildren() {
		return children;
	}

	public void setChildren(List<AreaMinorTag> children) {
		this.children = children;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}

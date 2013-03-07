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
 * 能耗次索引节点
 * @author user
 *
 */
@Entity
@Table(name="T_Energy_Minor_Tag")
public class EnergyMinorTag extends AbstractPersistable<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8822924796703061008L;
	private String name;// 名称
	private String type;// 类型或编号
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private EnergyMinorTag parent;
	
	@OneToMany(mappedBy="parent")
	private List<EnergyMinorTag> children;
	
	@OneToMany(mappedBy = "energyMinorTag")
	private List<EndTag> endTagList;
	
	/*非持久化字段*/
	@Transient
	private String path;

	public EnergyMinorTag() {
	}
	
	public EnergyMinorTag(int id) {
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

	public EnergyMinorTag getParent() {
		return parent;
	}

	public void setParent(EnergyMinorTag parent) {
		this.parent = parent;
	}

	public List<EnergyMinorTag> getChildren() {
		return children;
	}

	public void setChildren(List<EnergyMinorTag> children) {
		this.children = children;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<EndTag> getEndTagList() {
		return endTagList;
	}

	public void setEndTagList(List<EndTag> endTagList) {
		this.endTagList = endTagList;
	}
	
}

package com.ht.scada.common.tag.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 主索引节点<br>
 * 用于描述主要的树形结构如：厂/矿/队/井
 * 
 * @author 薄成文
 * 
 */
@Entity
@Table(name = "T_Major_Tag")
public class MajorTag extends AbstractPersistable<Integer> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 304892425065100122L;

	/**
	 * 节点名称<br>
	 * 需要在树形结构中显示的名称
	 */
	private String name;

	/**
	 * 父节点，用于描述树形结构
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private MajorTag parent;

	/**
	 * 该节点下的的所有子节点
	 */
	@OneToMany(mappedBy = "parent")
	private List<MajorTag> children; // 子节点

	@OneToMany(mappedBy = "majorTag")
	private List<EndTag> endTagList;

	public MajorTag() {
	}

	public MajorTag(int id) {
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MajorTag getParent() {
		return parent;
	}

	public void setParent(MajorTag parent) {
		this.parent = parent;
	}

	public List<MajorTag> getChildren() {
		return children;
	}

	public void setChildren(List<MajorTag> children) {
		this.children = children;
	}

	public List<EndTag> getEndTagList() {
		return endTagList;
	}

	public void setEndTagList(List<EndTag> endTagList) {
		this.endTagList = endTagList;
	}

}

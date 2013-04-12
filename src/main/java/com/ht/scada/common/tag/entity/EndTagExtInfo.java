package com.ht.scada.common.tag.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 末端节点扩展信息
 * @author 薄成文
 *
 */
@Entity
@Table(name = "T_End_Ext_Info")
public class EndTagExtInfo extends AbstractPersistable<Integer> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2289322729789824950L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="end_tag_id")
	private EndTag endTag;
	
	private String name;
	private String value;

	public EndTagExtInfo() {
	}

	public EndTagExtInfo(int id) {
		setId(id);
	}

	public EndTag getEndTag() {
		return endTag;
	}
	
	public void setEndTag(EndTag endTag) {
		this.endTag = endTag;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

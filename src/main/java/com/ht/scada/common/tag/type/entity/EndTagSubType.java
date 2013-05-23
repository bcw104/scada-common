package com.ht.scada.common.tag.type.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 监控对象子类型类型
 * @author 赵磊
 *
 */
@Entity
@Table(name = "T_Type_EndTagSub")
public class EndTagSubType extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1244714691581606734L;
	/**
	 * 英文名
	 */
	private String name;
	/**
	 * 中文值
	 */
	private String value;
	
	
	public EndTagSubType() {
	}
	public EndTagSubType(String name, String value) {
		this.name = name;
		this.value = value;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endTag_id")
	private EndTagType endTagType;
	
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
	public EndTagType getEndTagType() {
		return endTagType;
	}
	public void setEndTagType(EndTagType endTagType) {
		this.endTagType = endTagType;
	}


}

package com.ht.scada.common.tag.type;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 监控对象扩展信息属性列表值
 * @author 赵磊
 *
 */
@Entity
@Table(name = "T_Type_ExtName")
public class EndTagExtInfoValue extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3475086757734005579L;
	
	public EndTagExtInfoValue() {
	}
	/**
	 * 英文名
	 */
	private String name;
	/**
	 * 中文值
	 */
	private String value;
	
	public EndTagExtInfoValue(String name, String value) {
		this.name = name;
		this.value = value;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "extName_id")
	private EndTagExtInfoName endTagExtInfoName;
	
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

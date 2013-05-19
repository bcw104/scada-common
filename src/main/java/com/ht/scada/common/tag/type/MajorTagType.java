package com.ht.scada.common.tag.type;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 主索引类型
 * @author 赵磊
 *
 */
@Entity
@Table(name = "T_Type_MajorTag")
public class MajorTagType extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3475086757734005579L;
	
	/**
	 * 英文名
	 * CHANG_LEVEL,KUANG_LEVEL,DUI_LEVEL
	 */
	private String name;
	/**
	 * 中文值
	 * 厂、矿、队
	 */
	private String value;
	
	private int level;
	
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	

}

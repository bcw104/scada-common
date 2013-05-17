package com.ht.scada.common.tag.type;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 监控对象类型
 * @author 赵磊
 *
 */
@Entity
@Table(name = "T_Type_EndTag")
public class EndTagType extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3475086757734005579L;
	
	/**
	 * 英文名
	 */
	private String name;
	/**
	 * 中文值
	 */
	private String value;
	
	@OneToMany(mappedBy = "endTagType")
	private List<EndTagSubType> endTagSubTypeList;
	
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

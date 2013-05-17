package com.ht.scada.common.tag.type;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 变量子类型
 * @author 赵磊
 *
 */
@Entity
@Table(name = "T_Type_VarSubType")
public class VarSubType extends AbstractPersistable<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2217695722650752315L;
	/**
	 * 英文名
	 */
	private String name;
	/**
	 * 中文值
	 */
	private String value;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id")
	private VarGroupType varGroupType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "var_id")
	private VarType varType;
	
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
	public VarGroupType getVarGroupType() {
		return varGroupType;
	}
	public void setVarGroupType(VarGroupType varGroupType) {
		this.varGroupType = varGroupType;
	}
	public VarType getVarType() {
		return varType;
	}
	public void setVarType(VarType varType) {
		this.varType = varType;
	}
	
	

}

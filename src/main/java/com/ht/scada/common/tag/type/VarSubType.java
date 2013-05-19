package com.ht.scada.common.tag.type;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.ht.scada.common.tag.entity.VarGroupCfg;

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
	private VarGroupCfg varGroupCfg;
	
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
	public VarType getVarType() {
		return varType;
	}
	public void setVarType(VarType varType) {
		this.varType = varType;
	}
	public VarGroupCfg getVarGroupCfg() {
		return varGroupCfg;
	}
	public void setVarGroupCfg(VarGroupCfg varGroupCfg) {
		this.varGroupCfg = varGroupCfg;
	}
	
	

}

package com.ht.scada.common.tag.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 末端节点各变量的IO信息设定，如果没有相应记录则采用变量模板中的默认值
 * 
 * @author 薄成文
 * 
 */
@Entity
@Table(name = "T_Var_IO_Info")
public class VarIOInfo extends AbstractPersistable<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6647181244609273696L;

	@ManyToOne(fetch = FetchType.LAZY)
	private EndTag endTag;
	
	private String varName;
	
	@Column(name = "base_value")
	private float baseValue = 0;// 基值
	
	@Column(name = "coef_value")
	private float coefValue = 1;// 系数

	public EndTag getEndTag() {
		return endTag;
	}

	public void setEndTag(EndTag endTag) {
		this.endTag = endTag;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public float getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(float baseValue) {
		this.baseValue = baseValue;
	}

	public float getCoefValue() {
		return coefValue;
	}

	public void setCoefValue(float coefValue) {
		this.coefValue = coefValue;
	}

}

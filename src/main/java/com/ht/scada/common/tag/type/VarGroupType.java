package com.ht.scada.common.tag.type;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 变量分组类型
 * @author 赵磊
 *
 */
@Entity
@Table(name = "T_Type_VarGroup")
public class VarGroupType extends AbstractPersistable<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2217695722650752315L;
	/**
	 * 英文名
	 * DIAN_YC,DIAN_YM
	 */
	private String name;
	/**
	 * 中文值
	 * 电力数据、电能数据
	 */
	private String value;
	
	@OneToMany(mappedBy = "varGroupType")
	private List<VarSubType> varSubTypeList;
	
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
	public List<VarSubType> getVarSubTypeList() {
		return varSubTypeList;
	}
	public void setVarSubTypeList(List<VarSubType> varSubTypeList) {
		this.varSubTypeList = varSubTypeList;
	}
	
	

}

package com.ht.scada.common.tag.type;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.ht.scada.common.tag.entity.VarGroupCfg;

/**
 * 监控对象类型
 * 
 * @author 赵磊
 * 
 */
@Entity
@Table(name = "T_Type_EndTag")
public class EndTagType extends AbstractPersistable<Integer> {

	/**
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = -840731598127978638L;
	/**
	 * 英文名
	 */
	private String name;
	/**
	 * 中文值
	 */
	private String value;
	
	

	public EndTagType() {
	}

	public EndTagType(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@OneToMany(mappedBy = "endTagType")
	private List<EndTagSubType> endTagSubTypeList;
	
	@OneToMany(mappedBy = "endTagType")
	private List<EndTagExtInfoName> endTagExtInfoNameList;
	

	@ManyToMany(targetEntity = com.ht.scada.common.tag.entity.VarGroupCfg.class, cascade = {
			CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "T_endTagType_varGroupType", joinColumns = { @JoinColumn(name = "endTagType_id") }, inverseJoinColumns = { @JoinColumn(name = "varGroupType_id") })
	private Set<VarGroupCfg> varGroupCfgSet;

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

	public List<EndTagSubType> getEndTagSubTypeList() {
		return endTagSubTypeList;
	}

	public void setEndTagSubTypeList(List<EndTagSubType> endTagSubTypeList) {
		this.endTagSubTypeList = endTagSubTypeList;
	}

	public Set<VarGroupCfg> getVarGroupCfgSet() {
		return varGroupCfgSet;
	}

	public void setVarGroupCfgSet(Set<VarGroupCfg> varGroupCfgSet) {
		this.varGroupCfgSet = varGroupCfgSet;
	}

	public List<EndTagExtInfoName> getEndTagExtInfoNameList() {
		return endTagExtInfoNameList;
	}

	public void setEndTagExtInfoNameList(
			List<EndTagExtInfoName> endTagExtInfoNameList) {
		this.endTagExtInfoNameList = endTagExtInfoNameList;
	}

}

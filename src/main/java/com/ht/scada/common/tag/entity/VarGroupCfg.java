package com.ht.scada.common.tag.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 变量分组配置信息，包括分组名称，存储间隔
 * 
 * @author 薄成文
 * 
 */
@Entity
@Table(name = "T_Var_Group_Cfg")
public class VarGroupCfg extends AbstractPersistable<Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = 7009578228205867170L;

	private String value;//中文名
	
	private String name;// 英文名
	

	private int intvl = 0;// 存储间隔

	

	public VarGroupCfg() {
	}

	public VarGroupCfg(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    /**
     * 存储间隔(分钟)
     * @return
     */
	public int getIntvl() {
		return intvl;
	}

	public void setIntvl(int interval) {
		this.intvl = interval;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}

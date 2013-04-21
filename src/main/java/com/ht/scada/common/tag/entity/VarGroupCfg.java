package com.ht.scada.common.tag.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.ht.scada.common.tag.util.VarGroup;

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

	private VarGroup varGroup;
	
	private String name;// 分组名称
	
	@Column(name = "interval")
	private int interval = 0;// 存储间隔

	public VarGroup getVarGroup() {
		return varGroup;
	}

	public void setVarGroup(VarGroup varGroup) {
		this.varGroup = varGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}
	
}

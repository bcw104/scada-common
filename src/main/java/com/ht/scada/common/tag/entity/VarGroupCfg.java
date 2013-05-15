package com.ht.scada.common.tag.entity;

import com.ht.scada.common.tag.util.VarGroup;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

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

	@Enumerated(EnumType.STRING)
	private VarGroup varGroup;
	
	private String name;// 分组名称
	

	@Column(name = "storage_interval")
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

    /**
     * 存储间隔(分钟)
     * @return
     */
	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}
	
}

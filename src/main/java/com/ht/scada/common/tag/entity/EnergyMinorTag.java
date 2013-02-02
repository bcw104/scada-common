package com.ht.scada.common.tag.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 能耗次索引节点
 * @author user
 *
 */
@Entity
@Table(name="T_Energy_Minor_Tag")
public class EnergyMinorTag extends AbstractPersistable<Integer> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;// 名称
	private String type;// 类型或编号
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private EnergyMinorTag parent;
	
	@OneToMany(mappedBy="parent")
	private List<EnergyMinorTag> children;
	
	/*非持久化字段*/
	@Transient
	private String path;
}

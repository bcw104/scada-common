package com.ht.scada.common.tag.type;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 监控对象扩展信息属性值
 * @author 赵磊
 *
 */
@Entity
@Table(name = "T_Type_ExtValue")
public class EndTagExtInfoValue extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 7804089766699969412L;
	
	public EndTagExtInfoValue() {
	}
	/**
	 * 英文名
	 */
	private String name;
	/**
	 * 中文值
	 */
	private String value;
	
	public EndTagExtInfoValue(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	
	public EndTagExtInfoValue(String name, String value,
			EndTagExtInfoName endTagExtInfoName) {
		this.name = name;
		this.value = value;
		this.endTagExtInfoName = endTagExtInfoName;
	}


	public EndTagExtInfoName getEndTagExtInfoName() {
		return endTagExtInfoName;
	}
	public void setEndTagExtInfoName(EndTagExtInfoName endTagExtInfoName) {
		this.endTagExtInfoName = endTagExtInfoName;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "extName_id")
	private EndTagExtInfoName endTagExtInfoName;
	
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

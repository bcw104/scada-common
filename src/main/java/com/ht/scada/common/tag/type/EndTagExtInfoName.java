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
 * 监控对象扩展信息属性名
 * @author 赵磊
 *
 */
@Entity
@Table(name = "T_Type_ExtName")
public class EndTagExtInfoName extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = -8825800848802123245L;
	
	public EndTagExtInfoName() {
	}
	
	public EndTagExtInfoName(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public EndTagExtInfoName(String name, String value, EndTagType endTagType) {
		this.name = name;
		this.value = value;
		this.endTagType = endTagType;
	}
	/**
	 * 英文名
	 */
	private String name;
	/**
	 * 中文值
	 */
	private String value;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endTag_id")
	private EndTagType endTagType;
	
	@OneToMany(mappedBy = "endTagExtInfoName")
	private List<EndTagExtInfoValue> endTagExtInfoValueList;

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

	public EndTagType getEndTagType() {
		return endTagType;
	}

	public void setEndTagType(EndTagType endTagType) {
		this.endTagType = endTagType;
	}

	public List<EndTagExtInfoValue> getEndTagExtInfoValueList() {
		return endTagExtInfoValueList;
	}

	public void setEndTagExtInfoValueList(
			List<EndTagExtInfoValue> endTagExtInfoValueList) {
		this.endTagExtInfoValueList = endTagExtInfoValueList;
	}

}

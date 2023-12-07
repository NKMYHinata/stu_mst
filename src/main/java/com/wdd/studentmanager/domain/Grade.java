package com.wdd.studentmanager.domain;

import org.springframework.stereotype.Component;

/**
 * 年级实体类
 * 用于表示学生所属的年级信息
 */
@Component
public class Grade {
	private Long id; // 年级ID
	private String name; // 年级名称
	private String remark; // 年级备注
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

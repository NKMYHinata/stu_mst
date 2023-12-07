package com.wdd.studentmanager.domain;

/**
 * 用户实体类
 * 用于表示系统用户的信息
 */

public class Admin {
	private Long id; // 用户的唯一标识
	private String username; // 用户名
	private String password; // 密码
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

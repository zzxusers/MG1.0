package com.mg.application.user.entity;

import java.util.List;

import com.mg.application.menuauthority.entity.Menuauthority;



public class User {
	
	private Integer id;
	private String username;//姓名
	private String loginname;//登录账户
	private String password;
	private Integer usertype;//账户类型（超级管理员1，普通操作员2）
	private Integer sex;//性别（男1，女0）
	private String phone;
	private String email;
	private List<Menuauthority> li;
	public Integer getAuthority() {
		return authority;
	}
	public void setAuthority(Integer authority) {
		this.authority = authority;
	}
	private Integer authority;
	public List<Menuauthority> getLi() {
		return li;
	}
	public void setLi(List<Menuauthority> li) {
		this.li = li;
	}
	private Menuauthority menuauth;
	//private Organizeauthority organauth;
	public Menuauthority getMenuauth() {
		return menuauth;
	}
	public void setMenuauth(Menuauthority menuauth) {
		this.menuauth = menuauth;
	}
	/*public Organizeauthority getOrganauth() {
		return organauth;
	}
	public void setOrganauth(Organizeauthority organauth) {
		this.organauth = organauth;
	}*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUsertype() {
		return usertype;
	}
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	private Integer status;//状态
}

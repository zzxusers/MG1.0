package com.mg.application.authority.entity;

import java.util.List;

import com.mg.application.organizeauthority.entity.Organizeauthority;

public class ZuAuthority {
/*
 * 权限组的表
 */
	private Integer id ;//表示该权限组的id.唯一
	//private Integer organizeid;//节点id,表示这个权限组可以查看哪些节点
	private String name;//权限组的名称
	private List<Organizeauthority> lij;
	public List<Organizeauthority> getLij() {
		return lij;
	}
	public void setLij(List<Organizeauthority> lij) {
		this.lij = lij;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/*public Integer getOrganizeid() {
		return organizeid;
	}
	public void setOrganizeid(Integer organizeid) {
		this.organizeid = organizeid;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

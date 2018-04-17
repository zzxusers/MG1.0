package com.mg.application.organize.entity;

import java.util.List;

import com.mg.application.equipment.entity.Equipment;

public class Organize {
	private Integer id;
	public String getOrganizename() {
		return organizename;
	}
	public void setOrganizename(String organizename) {
		this.organizename = organizename;
	}
	private String organizename;
	private Integer fid;
	private List<Equipment> eqli;
	public List<Equipment> getEqli() {
		return eqli;
	}
	public void setEqli(List<Equipment> eqli) {
		this.eqli = eqli;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
}

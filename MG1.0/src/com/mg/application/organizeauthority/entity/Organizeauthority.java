package com.mg.application.organizeauthority.entity;

import java.util.List;

import com.mg.application.equipment.entity.Equipment;
import com.mg.application.organize.entity.Organize;

public class Organizeauthority {
	/*create table J_authority(
			id int(4) primary key auto_increment,
			valueid varchar(20) not null,
			authorityname varchar(20) not null
			)*/
	//节点权限表
	private Integer idj;//权限组id
	private Integer organizeid;//节点id,表示用户有那个几个节点的权限
	private Integer status;//节点状态，0,为显示，1，为隐藏
	private List<Equipment> li;//设备集合
	private List<Organize> lio;//节点集合
	public List<Organize> getLio() {
		return lio;
	}
	public void setLio(List<Organize> lio) {
		this.lio = lio;
	}
	public List<Equipment> getLi() {
		return li;
	}
	public void setLi(List<Equipment> li) {
		this.li = li;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIdj() {
		return idj;
	}
	public void setIdj(Integer idj) {
		this.idj = idj;
	}
	public Integer getOrganizeid() {
		return organizeid;
	}
	public void setOrganizeid(Integer organizeid) {
		this.organizeid = organizeid;
	}
	
}

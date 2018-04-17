package com.mg.application.equipmentauthority.entity;

import java.util.List;

import com.mg.application.equipment.entity.Equipment;

public class EquipmentAuthority {
/*
 * 设备权限表
 */
	
	private Integer organizeid;//节点id,该id与节点表的节点id相关联，表示该该设备属于哪个节点
	private Integer equipmentid;//设备id,表示哪个设备
	private Integer status;//状态，0,为可以查看，1为不可查看
	private Integer zu_id;//属于哪个权限组的id
	public Integer getZu_id() {
		return zu_id;
	}
	public void setZu_id(Integer zu_id) {
		this.zu_id = zu_id;
	}
	private List<Equipment> li;
	public List<Equipment> getLi() {
		return li;
	}
	public void setLi(List<Equipment> li) {
		this.li = li;
	}
	public Integer getOrganizeid() {
		return organizeid;
	}
	public void setOrganizeid(Integer organizeid) {
		this.organizeid = organizeid;
	}
	public Integer getEquipmentid() {
		return equipmentid;
	}
	public void setEquipmentid(Integer equipmentid) {
		this.equipmentid = equipmentid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

package com.mg.application.equipmentauthority.entity;

import java.util.List;

import com.mg.application.equipment.entity.Equipment;

public class EquipmentAuthority {
/*
 * �豸Ȩ�ޱ�
 */
	
	private Integer organizeid;//�ڵ�id,��id��ڵ��Ľڵ�id���������ʾ�ø��豸�����ĸ��ڵ�
	private Integer equipmentid;//�豸id,��ʾ�ĸ��豸
	private Integer status;//״̬��0,Ϊ���Բ鿴��1Ϊ���ɲ鿴
	private Integer zu_id;//�����ĸ�Ȩ�����id
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

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
	//�ڵ�Ȩ�ޱ�
	private Integer idj;//Ȩ����id
	private Integer organizeid;//�ڵ�id,��ʾ�û����Ǹ������ڵ��Ȩ��
	private Integer status;//�ڵ�״̬��0,Ϊ��ʾ��1��Ϊ����
	private List<Equipment> li;//�豸����
	private List<Organize> lio;//�ڵ㼯��
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

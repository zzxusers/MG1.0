package com.mg.application.authority.entity;

import java.util.List;

import com.mg.application.organizeauthority.entity.Organizeauthority;

public class ZuAuthority {
/*
 * Ȩ����ı�
 */
	private Integer id ;//��ʾ��Ȩ�����id.Ψһ
	//private Integer organizeid;//�ڵ�id,��ʾ���Ȩ������Բ鿴��Щ�ڵ�
	private String name;//Ȩ���������
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

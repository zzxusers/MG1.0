package com.mg.application.organizeauthority.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mg.application.organizeauthority.entity.Organizeauthority;


public interface OrganizeAuthorityService {
	public int add_organizeauthority(Integer zu_id,Integer j_id,Integer status);
	//���ҽڵ�Ȩ��
	public List<Organizeauthority> sel_orgauthority(Integer id);
	//������ӽڵ�Ȩ��(Ȩ�����id)
		public int add_organ(Integer id);
		//�������½ڵ�Ȩ��
		public int upd_organ(Integer zu_id,int j[],int status[]);
		//����ɾ���ڵ�Ȩ��
		public int del_organ(@Param("zu_id")Integer zu_id);
		//���ҽڵ�Ȩ�ޣ�ʵ��Ӧ�ã�
		public List<Organizeauthority> sel_authoritys(@Param("jid")Integer jid,@Param("zu_id")Integer zu_id);
		//�����һ���ڵ��ʱ��ͬʱ��Ҫ�����е�Ȩ�����µĽڵ�Ȩ����ӽڵ�Ȩ����
		public int add_organzu(Integer jid);
}

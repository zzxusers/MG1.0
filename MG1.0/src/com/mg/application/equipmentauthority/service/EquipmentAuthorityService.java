package com.mg.application.equipmentauthority.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mg.application.equipmentauthority.entity.EquipmentAuthority;



public interface EquipmentAuthorityService {
	//��������豸Ȩ�ޡ�
		public int add_equipmentAuthority(Integer jid,Integer sid);
	//�����豸����ѯ��Ҫ��ѯ�Ľڵ��µ����п��Բ鿴���豸�����ݽڵ�id��
		public List<EquipmentAuthority> sel_equipmentauthority(Integer id,Integer zu_id);
		//���������豸Ȩ��
		public int add_sauth(Integer zu_id);
		
		public int upd_sauth(Integer zu_id,int equipmentid[],int status[]);
		//����ɾ���豸Ȩ��
		public int del_sauth(Integer zu_id);
}

package com.mg.application.equipmentauthority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.equipmentauthority.entity.EquipmentAuthority;

@Repository("equipmentAuthorityDao")
public interface EquipmentauthorityDao {
	/*
	 * �豸Ȩ��dao
	 *///(�ڵ�id,�豸id,״̬)
	//public int add_equipmentAuthority(@Param("j_id")Integer j_id,@Param("s_id")Integer s_id,@Param("status")Integer status);
	public int add_equipmentAuthoritys(@Param("equipmentau")List<EquipmentAuthority> equipmentau);
	//�����豸����ѯ��Ҫ��ѯ�Ľڵ��µ����п��Բ鿴���豸�����ݽڵ�id��
	public List<EquipmentAuthority> sel_equipmentauthority(@Param("id")Integer id,@Param("zu_id")Integer zu_id);
	//���������豸Ȩ��
	public int add_sauth(@Param("zu_id")Integer zu_id);
	//���������豸Ȩ��
	public int upd_sauth(@Param("list")List<EquipmentAuthority> list);
	//����ɾ���豸Ȩ��
	public int del_sauth(@Param("zu_id")Integer zu_id);
}

package com.mg.application.menuauthority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.menuauthority.entity.Menuauthority;

/*
 * �˵�Ȩ�޹���
 */
@Repository("menuDao")
public interface MenuAuthorityDao {
	//��������˵�Ȩ��
	public int add_menuauth(@Param("list")List<Menuauthority> list);
	//�������²˵�Ȩ��
	public int upd_menuauth(@Param("list")List<Menuauthority> list);
	//����ɾ���˵�Ȩ��
	public int del_menuauth(Integer zu_id);
}

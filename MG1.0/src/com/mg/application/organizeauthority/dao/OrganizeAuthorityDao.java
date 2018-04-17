package com.mg.application.organizeauthority.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.organizeauthority.entity.Organizeauthority;

/*
 * �ڵ�Ȩ��dao
 */
@Repository("organizeAuthorityDao")
public interface OrganizeAuthorityDao {
	public int add_organizeauthority(@Param("zu_id")Integer zu_id,@Param("j_id")Integer j_id,@Param("status")Integer status);
	//���ҽڵ�Ȩ��
	public List<Organizeauthority> sel_orgauthority(@Param("id")Integer id);
	//���ҽڵ�Ȩ�ޣ�ʵ��Ӧ�ã�
	public List<Organizeauthority> sel_authoritys(@Param("jid")Integer jid,@Param("zu_id")Integer zu_id);
	//������ӽڵ�Ȩ�ޣ�����Ȩ�����ʱ���õ�(Ȩ�����id)
	public int add_organ(@Param("id")Integer id);
	//�����һ���ڵ��ʱ��ͬʱ��Ҫ�����е�Ȩ�����µĽڵ�Ȩ����ӽڵ�Ȩ����
	public int add_organzu(@Param("od")List<Organizeauthority> od);
	//�������½ڵ�Ȩ��Map<String,Object> param
	public int upd_organ(@Param("param")List<Organizeauthority> li);
	//����ɾ���ڵ�Ȩ��
	public int del_organ(@Param("zu_id")Integer zu_id);
}

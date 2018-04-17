package com.mg.application.authority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.authority.entity.ZuAuthority;

@Repository("authorityDao")
public interface AuthorityDAO {
/*
 * Ȩ�������ɾ�Ĳ�
 */
	//����Ȩ����
	public int add_authority(@Param("zuauto")ZuAuthority zuauto);
	//����Ȩ���飨ʵ��Ӧ�ã�
	public List<Object> sel_authoritys(@Param("id")Integer id,@Param("zu_id")Integer zu_id);
	//����Ȩ����
	public List<ZuAuthority> sel_authority(@Param("id")Integer id);
	//����Ȩ����
	public int upd_authority(@Param("name")String name,@Param("zu_id")Integer zu_id);
	//ɾ��Ȩ����
	public int del_authority(@Param("zu_id")Integer zu_id);
	
}

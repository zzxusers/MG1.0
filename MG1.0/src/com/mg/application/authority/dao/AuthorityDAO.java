package com.mg.application.authority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.authority.entity.ZuAuthority;

@Repository("authorityDao")
public interface AuthorityDAO {
/*
 * 权限组的增删改查
 */
	//增加权限组
	public int add_authority(@Param("zuauto")ZuAuthority zuauto);
	//查找权限组（实际应用）
	public List<Object> sel_authoritys(@Param("id")Integer id,@Param("zu_id")Integer zu_id);
	//查找权限组
	public List<ZuAuthority> sel_authority(@Param("id")Integer id);
	//更新权限组
	public int upd_authority(@Param("name")String name,@Param("zu_id")Integer zu_id);
	//删除权限组
	public int del_authority(@Param("zu_id")Integer zu_id);
	
}

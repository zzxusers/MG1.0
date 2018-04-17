package com.mg.application.menuauthority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.menuauthority.entity.Menuauthority;

/*
 * 菜单权限管理
 */
@Repository("menuDao")
public interface MenuAuthorityDao {
	//批量插入菜单权限
	public int add_menuauth(@Param("list")List<Menuauthority> list);
	//批量更新菜单权限
	public int upd_menuauth(@Param("list")List<Menuauthority> list);
	//批量删除菜单权限
	public int del_menuauth(Integer zu_id);
}

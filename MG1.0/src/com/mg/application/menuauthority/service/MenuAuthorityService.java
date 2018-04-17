package com.mg.application.menuauthority.service;


public interface MenuAuthorityService {
	//批量插入菜单权限
	public int add_menuauth(Integer zu_id,int[] cid,Integer status);
	//批量更新菜单权限
	public int upd_menuauth(Integer zu_id,int[] cid,int status[]);
	//批量删除菜单权限
	public int del_menuauth(Integer zu_id);
}

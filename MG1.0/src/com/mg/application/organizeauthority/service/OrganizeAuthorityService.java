package com.mg.application.organizeauthority.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mg.application.organizeauthority.entity.Organizeauthority;


public interface OrganizeAuthorityService {
	public int add_organizeauthority(Integer zu_id,Integer j_id,Integer status);
	//查找节点权限
	public List<Organizeauthority> sel_orgauthority(Integer id);
	//批量添加节点权限(权限组的id)
		public int add_organ(Integer id);
		//批量更新节点权限
		public int upd_organ(Integer zu_id,int j[],int status[]);
		//批量删除节点权限
		public int del_organ(@Param("zu_id")Integer zu_id);
		//查找节点权限（实际应用）
		public List<Organizeauthority> sel_authoritys(@Param("jid")Integer jid,@Param("zu_id")Integer zu_id);
		//当添加一个节点的时候，同时还要给所有的权限组下的节点权限添加节点权限组
		public int add_organzu(Integer jid);
}

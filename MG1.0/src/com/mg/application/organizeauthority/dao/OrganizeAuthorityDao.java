package com.mg.application.organizeauthority.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.organizeauthority.entity.Organizeauthority;

/*
 * 节点权限dao
 */
@Repository("organizeAuthorityDao")
public interface OrganizeAuthorityDao {
	public int add_organizeauthority(@Param("zu_id")Integer zu_id,@Param("j_id")Integer j_id,@Param("status")Integer status);
	//查找节点权限
	public List<Organizeauthority> sel_orgauthority(@Param("id")Integer id);
	//查找节点权限（实际应用）
	public List<Organizeauthority> sel_authoritys(@Param("jid")Integer jid,@Param("zu_id")Integer zu_id);
	//批量添加节点权限，插入权限组的时候用的(权限组的id)
	public int add_organ(@Param("id")Integer id);
	//当添加一个节点的时候，同时还要给所有的权限组下的节点权限添加节点权限组
	public int add_organzu(@Param("od")List<Organizeauthority> od);
	//批量更新节点权限Map<String,Object> param
	public int upd_organ(@Param("param")List<Organizeauthority> li);
	//批量删除节点权限
	public int del_organ(@Param("zu_id")Integer zu_id);
}

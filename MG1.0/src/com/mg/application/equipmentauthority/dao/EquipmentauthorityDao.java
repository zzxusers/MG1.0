package com.mg.application.equipmentauthority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.equipmentauthority.entity.EquipmentAuthority;

@Repository("equipmentAuthorityDao")
public interface EquipmentauthorityDao {
	/*
	 * 设备权限dao
	 *///(节点id,设备id,状态)
	//public int add_equipmentAuthority(@Param("j_id")Integer j_id,@Param("s_id")Integer s_id,@Param("status")Integer status);
	public int add_equipmentAuthoritys(@Param("equipmentau")List<EquipmentAuthority> equipmentau);
	//查找设备（查询所要查询的节点下的所有可以查看的设备）根据节点id查
	public List<EquipmentAuthority> sel_equipmentauthority(@Param("id")Integer id,@Param("zu_id")Integer zu_id);
	//批量导入设备权限
	public int add_sauth(@Param("zu_id")Integer zu_id);
	//批量更新设备权限
	public int upd_sauth(@Param("list")List<EquipmentAuthority> list);
	//批量删除设备权限
	public int del_sauth(@Param("zu_id")Integer zu_id);
}

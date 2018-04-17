package com.mg.application.equipmentauthority.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mg.application.equipmentauthority.entity.EquipmentAuthority;



public interface EquipmentAuthorityService {
	//批量添加设备权限。
		public int add_equipmentAuthority(Integer jid,Integer sid);
	//查找设备（查询所要查询的节点下的所有可以查看的设备）根据节点id查
		public List<EquipmentAuthority> sel_equipmentauthority(Integer id,Integer zu_id);
		//批量导入设备权限
		public int add_sauth(Integer zu_id);
		
		public int upd_sauth(Integer zu_id,int equipmentid[],int status[]);
		//批量删除设备权限
		public int del_sauth(Integer zu_id);
}

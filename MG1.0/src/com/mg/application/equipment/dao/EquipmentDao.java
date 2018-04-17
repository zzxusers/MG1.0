package com.mg.application.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.equipment.entity.Equipment;
import com.mg.application.equipmentauthority.entity.EquipmentAuthority;

/*
 * 设备管理接口
 */
@Repository("equipmentDao")
public interface EquipmentDao {
	/*private Integer id;// 编号
	private Integer joins;// 连接方式
	private Integer equipmenttype;// 设备类型
	private String equipmentname;// 设备名称
	private Integer shop;// 厂家
	private String equipmentversion;// 设备型号
	private String ip;// IP地址
	private Integer ports;// 端口
	private String loginname;// 账户
	private String loginpaws;// 密码
	private Integer orgznizeid;// 组织结构
	private Integer pas_scount;// 通道数
	private Integer pass_type;// 通道类型
	private String txt;// 描述说明
*/	//添加设备
	public int add_equipment(@Param("eq")Equipment eq,@Param("equipmentau")List<EquipmentAuthority> equipmentau); 
	//删除设备（同时还要批量删除设备权限组的数据）
	public int del_equipment(@Param("id")Integer id);
	//更新
	public int upd_equipment(@Param("id")Integer id,@Param("joins")Integer joins,@Param("equipmenttype")Integer equipmenttype,
							@Param("equipmentname")String equipmentname,
							@Param("shop")Integer shop,
							@Param("equipmentversion")String equipmentversion,
							@Param("ip")String ip,
							@Param("ports")Integer ports,
							@Param("loginname")String loginname,
							@Param("loginpaws")String loginpaws,
							@Param("orgznizeid")Integer orgznizeid,
							@Param("pass_count")Integer pass_count,
							@Param("pass_type")Integer pass_type,
							@Param("txt")String txt
			
			);
	//查找设备,可以根据id查询，组织结构查询，设备名称查询,currentpage当前页码，首次进入默认为0 
	public List<Equipment> sel_quipment(@Param("id")Integer id,@Param("equipmentname")String equipmentname,@Param("organizename")String organizename,@Param("currentpage")Integer currentpage,@Param("organizeid")Integer organizeid);
	//批量导入设备权限
	// INSERT INTO s_authority (organizeid,equipmentid) SELECT orgznizeid,id FROM equipment;
	//public int add_sauth();
	
}

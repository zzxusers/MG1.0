package com.mg.application.equipment.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mg.application.equipment.entity.Equipment;

public interface EquipmentService {

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
	public int add_equipment(Equipment eq); 
	//删除设备
	public int del_equipment(Integer id[]);
	//更新
	public int upd_equipment(Integer id,Integer joins,Integer equipmenttype,
							String equipmentname,
							Integer shop,
							String equipmentversion,
							String ip,
							Integer ports,
							String loginname,
							String loginpaws,
							Integer orgznizeid,
							Integer pass_count,
							Integer pass_type,
							String txt
			
			);
	//查找设备
	public List<Equipment> sel_quipment(@Param("id")Integer id,@Param("equipmentname")String equipmentname,@Param("organizename")String organizename,@Param("currentpage")Integer currentpage,@Param("organizeid")Integer organizeid);
	//public int add_sauth();

}

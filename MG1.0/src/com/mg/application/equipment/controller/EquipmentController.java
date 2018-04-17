package com.mg.application.equipment.controller;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mg.application.equipment.entity.Equipment;
import com.mg.application.equipment.service.EquipmentService;
import com.mg.application.equipmentauthority.service.EquipmentAuthorityService;
import com.mg.application.user.util.Get_json;

@Controller
public class EquipmentController {
	@Resource(name="equipmentService")
	private EquipmentService equipment;
	@Resource(name="equipmentAuthorityService")
	private EquipmentAuthorityService es;
	// String message;
	//private boolean status;
	@RequestMapping(value="/addequipment",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object addequipment(Equipment eq){//设备添加
		System.out.println("设备添加");
		int i = equipment.add_equipment(eq);
		if(i!=0){
			//os.a
			//es.add_equipmentAuthority(eq.getOrganizeid(), eq.getId());//添加设备权限
			return Get_json.setjson(null, false,"添加成功");
		}
		return Get_json.setjson(null,false,"添加失败");
	}
	@RequestMapping(value="/delequipment",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object delequipment(Integer id[]){//删除设备
		int i = equipment.del_equipment(id);
		System.out.println("s删除"+i);
		if(i!=0){
			return Get_json.setjson(null,true,"删除成功");
		}
		return Get_json.setjson(null,false,"删除失败");
	}
	@RequestMapping(value="/updequipment",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object updequipment(
			@RequestParam(value="id",required=false)Integer id,
			@RequestParam(value="joins",required=false)Integer joins,
			@RequestParam(value="equipmenttype",required=false)Integer equipmenttype,
			@RequestParam(value="equipmentname",required=false)String equipmentname,
			@RequestParam(value="shop",required=false)Integer shop,
			@RequestParam(value="equipmentversion",required=false)String equipmentversion,
			@RequestParam(value="ip",required=false)String ip,
			@RequestParam(value="ports",required=false)Integer ports,
			@RequestParam(value="loginname",required=false)String loginname,
			@RequestParam(value="loginpaws",required=false)String loginpaws,
			@RequestParam(value="orgznizeid",required=false)Integer orgznizeid,
			@RequestParam(value="pass_count",required=false)Integer pass_count,
			@RequestParam(value="pass_type",required=false)Integer pass_type,
			@RequestParam(value="txt",required=false)String txt){//设备更新
		int i = equipment.upd_equipment(id, joins, equipmenttype, equipmentname, shop, equipmentversion, ip, ports, loginname, loginpaws, orgznizeid, pass_count, pass_type, txt);
		if(i!=0){
			return Get_json.setjson(null,true,"更新成功");
		}
		return Get_json.setjson(null,false,"更新发生错误");
	}
	@RequestMapping(value="/selequipment",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object selequipment(@RequestParam(value="id",required=false)Integer id,
			@RequestParam(value="equipmentname",required=false)String equipmentname,
			@RequestParam(value="organizename",required=false)String organizename,
			@RequestParam(value="currentpage",required=false)Integer currentpage,
			@RequestParam(value="organizeid",required=false)Integer organizeid)
			
	{//查找设备，如果没有传id,则查询全部的设备
		List<Equipment> li  = equipment.sel_quipment(id,equipmentname,organizename,currentpage,organizeid);
		JSONArray json = JSONArray.fromObject(li);
		if(json!=null){
			return Get_json.setjson(json,true,"查询成功");
		}
		return Get_json.setjson(null,false,"查询发生错误，请重试");
	}
}

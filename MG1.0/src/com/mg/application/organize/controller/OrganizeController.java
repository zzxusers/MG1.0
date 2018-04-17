package com.mg.application.organize.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mg.application.equipment.entity.Equipment;
import com.mg.application.equipment.service.EquipmentService;
import com.mg.application.organize.entity.Organize;
import com.mg.application.organize.service.OrganizeService;
import com.mg.application.organizeauthority.service.OrganizeAuthorityService;
import com.mg.application.user.util.Get_bean;
import com.mg.application.user.util.Get_json;

@Controller
public class OrganizeController {
	@Resource(name="organizeService")
	private OrganizeService os;
	@Resource(name="equipmentService")
	private EquipmentService es;
	@Resource(name="organizeauthorityService")
	private OrganizeAuthorityService oa;
	@RequestMapping(value="/selorganize",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public <T> Object st(Integer id){
		//查询节点，同时还要查询该节点下的摄像机
		@SuppressWarnings("unchecked")
		List<T> li = (List<T>) os.sel_organize(id);//节点集合
		List<Object> lis = new ArrayList<Object>();

		Integer organizeid = id;

		@SuppressWarnings("unchecked")
		List<T> lie = (List<T>) es.sel_quipment(null, null, null, null, organizeid);//设备集合
	//	List<Object> lio = new ArrayList<Object>();
		lis.add(li);
		lis.add(lie);
	//	List<T> LI = new ArrayList<T>();
		if(0 !=li.size() || 0!=lie.size() ){
			//return Get_json.setjson(lis, true,"查找成功");
			return Get_json.setjson(li, lie, true, "查找成功");
		}
		return Get_json.setjson(li,lie, true,"查找失败");//http://ZZX-PC:6060/MG1.0/
	}
	@RequestMapping(value="/delorganize",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object delorganize(Integer id){
		int i = os.del_organize(id);
		if(i!=0){
			return Get_json.setjson(null, true,"删除成功");
		}
		return Get_json.setjson(null, false,"删除失败");
	}
	@RequestMapping(value="/updorganize",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object updorgainze(Integer id,String organizename){
		int i = os.upd_organize(id,organizename);
		if(i!=0){
			return Get_json.setjson(null, true,"更新成功");
		}
		return Get_json.setjson(null, false,"更新失败");
	}
	@RequestMapping(value="/addorganize",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object addorganize(Organize organize){
		int i = os.add_organize(organize);
		if(i!=0){//添加成功后，还需要在各个权限组进行添加
			oa.add_organzu(organize.getId());
			return Get_json.setjson(null, true,"添加成功");
		}
		return Get_json.setjson(null, false,"添加失败");
	}
}

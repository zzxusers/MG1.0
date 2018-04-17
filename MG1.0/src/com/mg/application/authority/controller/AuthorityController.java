package com.mg.application.authority.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mg.application.authority.entity.ZuAuthority;
import com.mg.application.authority.service.AuthorityService;
import com.mg.application.equipmentauthority.dao.EquipmentauthorityDao;
import com.mg.application.equipmentauthority.entity.EquipmentAuthority;
import com.mg.application.equipmentauthority.service.EquipmentAuthorityService;
import com.mg.application.organizeauthority.entity.Organizeauthority;
import com.mg.application.organizeauthority.service.OrganizeAuthorityService;
import com.mg.application.user.util.Get_bean;
import com.mg.application.user.util.Get_json;

@Controller
public class AuthorityController {
	@Resource(name="authorityService")
	private AuthorityService as ;
	@Resource(name="equipmentAuthorityService")
	private EquipmentAuthorityService ed;
	@Resource(name="organizeauthorityService")
	private OrganizeAuthorityService os;
	//查询权限（用户每单击一次节点就会去数据库查询该节点下有哪些子节点、子设备可以被查看）      selauthority
	@RequestMapping(value="/selauthority",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public <T> Object sel_authority(Integer jid,Integer zid){
		@SuppressWarnings("unchecked")
		List<T> lij = (List<T>) os.sel_authoritys(jid, zid);
		@SuppressWarnings("unchecked")
		List<T> lis = (List<T>) ed.sel_equipmentauthority(jid,zid);
		List<Object> list = new ArrayList<Object>();
		list.add(lij);
		list.add(lis);
		return Get_json.setjson(lij, lis, true, "成功");
		//return Get_json.setjson(list, true, "成功");
	}
	/*//用户单击节点后，查询出该用户可以查看该节点下的那些设备
	@RequestMapping(value="/selequipmentauthority",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object sel_equiauth(Integer id,Integer zu_id){
		List<EquipmentAuthority> li = ed.sel_equipmentauthority(id,zu_id);
		if(li!=null){
			return Get_json.setjson(li, true, "查询成功");
		}
		return Get_json.setjson(li, false, "查询失败");
	}*/
	//添加权限组（先将所有的节点都添加到节点权限表中，设备也是一样的。然后在根据返回的值，将我们选中的节点或者设备更新成可查看状态）
	@RequestMapping(value="/addauthority",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object add_authority(ZuAuthority zuauto){
		//先添加权限组
		int i = as.add_authority(zuauto);
		if(i!=0){//如果添加权限组成功，就开始添加节点和设备了
			//ed.add_equipmentAuthority(equipmentau);
			//OrganizeAuthorityService os = (OrganizeAuthorityService) Get_bean.sel_bean("organizeauthorityService");
			os.add_organ(zuauto.getId());//批量添加节点权限
			ed.add_sauth(zuauto.getId());//批量添加设备权限
			//接下来需要批量更新所选的节点权限和设备权限
		}
		return JSON.toJSONString("成功");
	}
	//删除权限组1
	@RequestMapping(value="/delauthority",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object del_authority(Integer id){
		int i = as.del_authority(id);
		System.out.println(i);
		return JSON.toJSONString("成功");
	}
	//更新权限组（只能更新权限组的名称）
	@RequestMapping(value="/updauthority",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object upd_authority(String name,Integer zu_id){
		int i = as.upd_authority(name, zu_id);
		return JSON.toJSONString("成功");
	}
}
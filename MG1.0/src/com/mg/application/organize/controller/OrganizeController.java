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
		//��ѯ�ڵ㣬ͬʱ��Ҫ��ѯ�ýڵ��µ������
		@SuppressWarnings("unchecked")
		List<T> li = (List<T>) os.sel_organize(id);//�ڵ㼯��
		List<Object> lis = new ArrayList<Object>();

		Integer organizeid = id;

		@SuppressWarnings("unchecked")
		List<T> lie = (List<T>) es.sel_quipment(null, null, null, null, organizeid);//�豸����
	//	List<Object> lio = new ArrayList<Object>();
		lis.add(li);
		lis.add(lie);
	//	List<T> LI = new ArrayList<T>();
		if(0 !=li.size() || 0!=lie.size() ){
			//return Get_json.setjson(lis, true,"���ҳɹ�");
			return Get_json.setjson(li, lie, true, "���ҳɹ�");
		}
		return Get_json.setjson(li,lie, true,"����ʧ��");//http://ZZX-PC:6060/MG1.0/
	}
	@RequestMapping(value="/delorganize",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object delorganize(Integer id){
		int i = os.del_organize(id);
		if(i!=0){
			return Get_json.setjson(null, true,"ɾ���ɹ�");
		}
		return Get_json.setjson(null, false,"ɾ��ʧ��");
	}
	@RequestMapping(value="/updorganize",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object updorgainze(Integer id,String organizename){
		int i = os.upd_organize(id,organizename);
		if(i!=0){
			return Get_json.setjson(null, true,"���³ɹ�");
		}
		return Get_json.setjson(null, false,"����ʧ��");
	}
	@RequestMapping(value="/addorganize",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object addorganize(Organize organize){
		int i = os.add_organize(organize);
		if(i!=0){//��ӳɹ��󣬻���Ҫ�ڸ���Ȩ����������
			oa.add_organzu(organize.getId());
			return Get_json.setjson(null, true,"��ӳɹ�");
		}
		return Get_json.setjson(null, false,"���ʧ��");
	}
}

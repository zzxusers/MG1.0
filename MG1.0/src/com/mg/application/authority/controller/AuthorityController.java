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
	//��ѯȨ�ޣ��û�ÿ����һ�νڵ�ͻ�ȥ���ݿ��ѯ�ýڵ�������Щ�ӽڵ㡢���豸���Ա��鿴��      selauthority
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
		return Get_json.setjson(lij, lis, true, "�ɹ�");
		//return Get_json.setjson(list, true, "�ɹ�");
	}
	/*//�û������ڵ�󣬲�ѯ�����û����Բ鿴�ýڵ��µ���Щ�豸
	@RequestMapping(value="/selequipmentauthority",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object sel_equiauth(Integer id,Integer zu_id){
		List<EquipmentAuthority> li = ed.sel_equipmentauthority(id,zu_id);
		if(li!=null){
			return Get_json.setjson(li, true, "��ѯ�ɹ�");
		}
		return Get_json.setjson(li, false, "��ѯʧ��");
	}*/
	//���Ȩ���飨�Ƚ����еĽڵ㶼��ӵ��ڵ�Ȩ�ޱ��У��豸Ҳ��һ���ġ�Ȼ���ڸ��ݷ��ص�ֵ��������ѡ�еĽڵ�����豸���³ɿɲ鿴״̬��
	@RequestMapping(value="/addauthority",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object add_authority(ZuAuthority zuauto){
		//�����Ȩ����
		int i = as.add_authority(zuauto);
		if(i!=0){//������Ȩ����ɹ����Ϳ�ʼ��ӽڵ���豸��
			//ed.add_equipmentAuthority(equipmentau);
			//OrganizeAuthorityService os = (OrganizeAuthorityService) Get_bean.sel_bean("organizeauthorityService");
			os.add_organ(zuauto.getId());//������ӽڵ�Ȩ��
			ed.add_sauth(zuauto.getId());//��������豸Ȩ��
			//��������Ҫ����������ѡ�Ľڵ�Ȩ�޺��豸Ȩ��
		}
		return JSON.toJSONString("�ɹ�");
	}
	//ɾ��Ȩ����1
	@RequestMapping(value="/delauthority",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object del_authority(Integer id){
		int i = as.del_authority(id);
		System.out.println(i);
		return JSON.toJSONString("�ɹ�");
	}
	//����Ȩ���飨ֻ�ܸ���Ȩ��������ƣ�
	@RequestMapping(value="/updauthority",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object upd_authority(String name,Integer zu_id){
		int i = as.upd_authority(name, zu_id);
		return JSON.toJSONString("�ɹ�");
	}
}
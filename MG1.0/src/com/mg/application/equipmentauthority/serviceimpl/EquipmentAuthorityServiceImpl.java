package com.mg.application.equipmentauthority.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mg.application.authority.entity.ZuAuthority;
import com.mg.application.authority.service.AuthorityService;
import com.mg.application.equipmentauthority.dao.EquipmentauthorityDao;
import com.mg.application.equipmentauthority.entity.EquipmentAuthority;
import com.mg.application.equipmentauthority.service.EquipmentAuthorityService;
import com.mg.application.organizeauthority.entity.Organizeauthority;
@Service("equipmentAuthorityService")
public class EquipmentAuthorityServiceImpl implements EquipmentAuthorityService{
	@Resource(name="equipmentAuthorityDao")
	private EquipmentauthorityDao eqautodao;
	@Resource(name="authorityService")
	private AuthorityService as;
	@Override
	public int add_equipmentAuthority(Integer jid,Integer sid) {//批量添加设备权限。
		// TODO Auto-generated method stub
		List<ZuAuthority> liz = as.sel_authority(null);//获取全部的权限组
		List<EquipmentAuthority> lie = new ArrayList<EquipmentAuthority>();
		for(int i = 0 ;i<=liz.size()-1;i++){
			EquipmentAuthority e = new EquipmentAuthority();
			e.setOrganizeid(jid);
			e.setEquipmentid(sid);
			e.setZu_id(liz.get(i).getId());
			lie.add(e);
		}
		int s = eqautodao.add_equipmentAuthoritys(lie);
		return s;
	}
	@Override  
	public List<EquipmentAuthority> sel_equipmentauthority(Integer id,Integer zu_id) {
		// TODO Auto-generated method stub
		List<EquipmentAuthority> li = eqautodao.sel_equipmentauthority(id,zu_id);
		return li;
	}
	@Override
	public int add_sauth(Integer zu_id) {
		// TODO Auto-generated method stub
		int i = eqautodao.add_sauth(zu_id);
		return i;
	}
	@Override
	public int upd_sauth(Integer zu_id, int[] equipmentid, int[] status) {
		// TODO Auto-generated method stub
		List<EquipmentAuthority> list = new ArrayList<EquipmentAuthority>();
		for(int i =0;i<=status.length-1;i++){
			EquipmentAuthority ea = new EquipmentAuthority();
			ea.setStatus(status[i]);
			ea.setEquipmentid(equipmentid[i]);
			ea.setZu_id(zu_id);
			list.add(ea);
		}
		
		int s = eqautodao.upd_sauth(list);
		return s;
	}
	@Override
	public int del_sauth(Integer zu_id) {
		// TODO Auto-generated method stub
		int i = eqautodao.del_sauth(zu_id);
		return i;
	}
	

}

package com.mg.application.equipment.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.mg.application.authority.entity.ZuAuthority;
import com.mg.application.authority.service.AuthorityService;
import com.mg.application.equipment.dao.EquipmentDao;
import com.mg.application.equipment.entity.Equipment;
import com.mg.application.equipment.service.EquipmentService;
import com.mg.application.equipmentauthority.entity.EquipmentAuthority;
@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService{
	@Resource(name="equipmentDao")
	private EquipmentDao equipmentDao;
	@Resource(name="authorityService")
	private AuthorityService as;
	@Override
	public int add_equipment(Equipment eq) {//添加设备的同时也要添加设备权限。
		// TODO Auto-generated method stub
		List<ZuAuthority> liz = as.sel_authority(null);//获取全部的权限组
		List<EquipmentAuthority> lie = new ArrayList<EquipmentAuthority>();
		
		for(int i = 0 ;i<=liz.size()-1;i++){
			EquipmentAuthority e = new EquipmentAuthority();
			e.setOrganizeid(eq.getOrganizeid());
			e.setEquipmentid(eq.getId());
			e.setZu_id(liz.get(i).getId());
			lie.add(e);
		}
		int i = equipmentDao.add_equipment(eq,lie);
		return i;
	}

	@Override
	public int del_equipment(Integer id[]) {
		// TODO Auto-generated method stub
		System.out.println(id);
		int i=0;
		for(int s = 0;s<=id.length-1;s++){//批量删除
			if(id[s]==null){
				break;
			}
			 equipmentDao.del_equipment(id[s]);
			 i++;
		}
		
		return i;
	}

	@Override
	public int upd_equipment(Integer id, Integer joins, Integer equipmenttype,
			String equipmentname, Integer shop, String equipmentversion,
			String ip, Integer ports, String loginname, String loginpaws,
			Integer orgznizeid, Integer pass_count, Integer pass_type,
			String txt) {
		// TODO Auto-generated method stub
		int i = equipmentDao.upd_equipment(id, joins, equipmenttype, equipmentname, shop, equipmentversion, ip, ports, loginname, loginpaws, orgznizeid, pass_count, pass_type, txt);
		return i;
	}

	@Override
	public List<Equipment> sel_quipment(Integer id,String equipmentname,String organizename,Integer currentpage,Integer organizeid) {
		// TODO Auto-generated method stub
		if(currentpage==null||currentpage==1||currentpage==0){
			currentpage=0;
		}else{
			currentpage=currentpage*2-2;
		}
		List<Equipment> li = equipmentDao.sel_quipment(id,equipmentname,organizename,currentpage,organizeid);
		return li;
	}

	
	
}

package com.mg.application.menuauthority.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mg.application.menuauthority.dao.MenuAuthorityDao;
import com.mg.application.menuauthority.entity.Menuauthority;
import com.mg.application.menuauthority.service.MenuAuthorityService;
@Service("menuServiceImpl")
public class MenuAuthorityServiceimpl implements MenuAuthorityService{
	@Resource(name="menuDao")
	private MenuAuthorityDao ms;
	@Override
	public int add_menuauth(Integer zu_id, int[] cid, Integer status) {
		// TODO Auto-generated method stub
		List<Menuauthority> list = new ArrayList<Menuauthority>();
		for(int i=0;i<=cid.length-1;i++){
			Menuauthority ma = new Menuauthority();
			ma.setCid(cid[i]);
			ma.setZid(zu_id);
			ma.setStatus(0);
			list.add(ma);
		}
		int k = ms.add_menuauth(list);
		return k;
	}
	@Override
	public int upd_menuauth(Integer zu_id, int[] cid, int[] status) {
		// TODO Auto-generated method stub
		List<Menuauthority> list = new ArrayList<Menuauthority>();
		for(int i= 0;i<=cid.length-1;i++){
			Menuauthority ma = new Menuauthority();
			ma.setCid(cid[i]);
			ma.setStatus(status[i ]);
			ma.setZid(zu_id);
			list.add(ma);
		}
		int k = ms.upd_menuauth(list);
		return k;
	}
	@Override
	public int del_menuauth(Integer zu_id) {
		// TODO Auto-generated method stub
		int i = ms.del_menuauth(zu_id);
		return i;
	}

}

package com.mg.application.authority.service;

import java.util.List;

import com.mg.application.authority.entity.ZuAuthority;

public interface AuthorityService {
	//增加权限组
		public int add_authority(ZuAuthority zuauto);
		//查找权限组
		public List<ZuAuthority> sel_authority(Integer id);
		//更新权限组
		public int upd_authority(String name,Integer zu_id);
		//删除权限组
		public int del_authority(Integer zu_id);
		
}

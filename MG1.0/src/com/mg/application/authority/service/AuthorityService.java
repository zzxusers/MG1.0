package com.mg.application.authority.service;

import java.util.List;

import com.mg.application.authority.entity.ZuAuthority;

public interface AuthorityService {
	//����Ȩ����
		public int add_authority(ZuAuthority zuauto);
		//����Ȩ����
		public List<ZuAuthority> sel_authority(Integer id);
		//����Ȩ����
		public int upd_authority(String name,Integer zu_id);
		//ɾ��Ȩ����
		public int del_authority(Integer zu_id);
		
}

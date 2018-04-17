package com.mg.application.authority.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mg.application.authority.dao.AuthorityDAO;
import com.mg.application.authority.entity.ZuAuthority;
import com.mg.application.authority.service.AuthorityService;
import com.mg.application.organizeauthority.dao.OrganizeAuthorityDao;
@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService{
	@Resource
	private AuthorityDAO authorityDao;
	@Resource(name="organizeAuthorityDao")
	private OrganizeAuthorityDao od;
	@Override
	public int add_authority(ZuAuthority zuauto) {
		// TODO Auto-generated method stub
		int i = authorityDao.add_authority(zuauto);
		return i;
	}
	@Override
	public List<ZuAuthority> sel_authority(Integer id) {
		// TODO Auto-generated method stub
		List<ZuAuthority> zu = authorityDao.sel_authority(id);
		return zu;
	}
	@Override
	public int upd_authority(String name, Integer zu_id) {
		// TODO Auto-generated method stub
		int i = authorityDao.upd_authority(name, zu_id);
		return i;
	}
	@Override
	public int del_authority(Integer zu_id) {
		// TODO Auto-generated method stub
		int i = authorityDao.del_authority(zu_id);
		return i;
	}
	

}

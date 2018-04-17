package com.mg.application.organize.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mg.application.organize.dao.OrganizeDao;
import com.mg.application.organize.entity.Organize;
import com.mg.application.organize.service.OrganizeService;
@Service("organizeService")
public class OrganizeServiceImpl implements OrganizeService{
	@Resource(name="organizeDao")
	private OrganizeDao organizeDao;

	@Override
	public List<Organize> sel_organize(Integer fid) {
		// TODO Auto-generated method stub
		List<Organize> li = organizeDao.sel_organize(fid);
		System.out.println(li.size());
		return li;
	}

	@Override
	public int del_organize(Integer id) {
		// TODO Auto-generated method stub
		int i = organizeDao.del_organize(id);
		return i;
	}

	@Override
	public int add_organize(Organize organize) {
		// TODO Auto-generated method stub
		int i = organizeDao.add_organize(organize);
		return i;
	}

	@Override
	public int upd_organize(Integer id, String organizename) {
		// TODO Auto-generated method stub
		int i = organizeDao.upd_organize(id, organizename);
		return i;
	}
	
	

}

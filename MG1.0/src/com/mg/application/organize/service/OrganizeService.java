package com.mg.application.organize.service;

import java.util.List;

import com.mg.application.organize.entity.Organize;

public interface OrganizeService { 
	//查找全部的结构组织
	public List<Organize> sel_organize(Integer fid);
	//删除节点，删除节点将会删除该节点下面的所有的子节点和设备。
	public int del_organize(Integer id);
	//增加节点
	public int add_organize(Organize organize);
	//更新节点,fid是为了标记要添加到那个父节点下
	public int upd_organize(Integer id,String organizename);
}

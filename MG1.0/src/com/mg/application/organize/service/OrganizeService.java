package com.mg.application.organize.service;

import java.util.List;

import com.mg.application.organize.entity.Organize;

public interface OrganizeService { 
	//����ȫ���Ľṹ��֯
	public List<Organize> sel_organize(Integer fid);
	//ɾ���ڵ㣬ɾ���ڵ㽫��ɾ���ýڵ���������е��ӽڵ���豸��
	public int del_organize(Integer id);
	//���ӽڵ�
	public int add_organize(Organize organize);
	//���½ڵ�,fid��Ϊ�˱��Ҫ��ӵ��Ǹ����ڵ���
	public int upd_organize(Integer id,String organizename);
}

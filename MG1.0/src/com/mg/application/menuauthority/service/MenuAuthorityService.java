package com.mg.application.menuauthority.service;


public interface MenuAuthorityService {
	//��������˵�Ȩ��
	public int add_menuauth(Integer zu_id,int[] cid,Integer status);
	//�������²˵�Ȩ��
	public int upd_menuauth(Integer zu_id,int[] cid,int status[]);
	//����ɾ���˵�Ȩ��
	public int del_menuauth(Integer zu_id);
}

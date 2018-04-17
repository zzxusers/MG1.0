package com.mg.application.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mg.application.user.entity.User;

public interface UserService {
	//��¼
	public User user_login(User user);
	//ע��
	public int add_user(User user);
	//ɾ���û�
	public int del_user(Integer userid);
	//�����û���Ϣ
	public int upd_user(Integer id,
			String username,
			String loginname,
			String password,
			Integer usertype,
			Integer sex,
			String phone,
			String email,
			Integer status,
			Integer authority
			);
	//��ѯ�û�
	public List<User> sel_user(Integer id);
}

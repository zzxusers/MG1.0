package com.mg.application.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mg.application.user.entity.User;

public interface UserService {
	//登录
	public User user_login(User user);
	//注册
	public int add_user(User user);
	//删除用户
	public int del_user(Integer userid);
	//更新用户信息
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
	//查询用户
	public List<User> sel_user(Integer id);
}

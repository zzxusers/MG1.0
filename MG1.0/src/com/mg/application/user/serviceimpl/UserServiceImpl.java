package com.mg.application.user.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mg.application.user.dao.UserDao;
import com.mg.application.user.entity.User;
import com.mg.application.user.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")
	private UserDao userdao;
	@Override
	public User user_login(User user) {
		// TODO Auto-generated method stub
		User u = userdao.user_login(user);
		return u;
	}
	@Override
	public int add_user(User user) {
		// TODO Auto-generated method stub
		int i = userdao.add_user(user);
		return i;
	}
	@Override
	public int del_user(Integer userid) {
		// TODO Auto-generated method stub
		int i = userdao.del_user(userid);
		return i;
	}
	@Override
	public int upd_user(Integer id,
						String username,
						String loginname,
						String password,
						Integer usertype,
						Integer sex,
						String phone,
						String email,
						Integer status,
						Integer authority){
		// TODO Auto-generated method stub
		int i = userdao.upd_user(id,username,loginname,password,usertype,sex,phone,email,status,authority);
		return i;
	}
	@Override
	public List<User> sel_user(Integer id) {
		// TODO Auto-generated method stub
		List<User> li = userdao.sel_user(id);
		return li;
	}
	

}

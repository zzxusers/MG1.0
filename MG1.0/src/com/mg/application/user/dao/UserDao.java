package com.mg.application.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.user.entity.User;
@Repository("userDao")
public interface UserDao {
	//�û���¼
	public User user_login(@Param("user")User user);
	//�û�ע��
	public int add_user(@Param("user")User user);
	/*create table users(
	id int(4) primary key auto_increment,
	username varchar(30) not null,
	loginname varchar(30) not null,
	password varchar(30) not null,
	usertype int(4) not null,
	sex int(2),
	phone varchar(30),
	emali varchar(30)
	)*/
	//�û���Ϣ����
	public int upd_user(@Param("id")Integer id,
						@Param("username")String username,
						@Param("loginname")String loginname,
						@Param("password")String password,
						@Param("usertype")Integer usertype,
						@Param("sex")Integer sex,
						@Param("phone")String phone,
						@Param("email")String email,
						@Param("status")Integer status,
						@Param("authority")Integer authority
						);
	//ɾ���û�
	public int del_user(@Param("userid")Integer userid);
	//��ѯ�û�
	public List<User> sel_user(@Param("id")Integer id);
}

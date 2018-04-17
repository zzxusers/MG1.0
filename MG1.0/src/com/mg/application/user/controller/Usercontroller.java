package com.mg.application.user.controller;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mg.application.user.entity.User;
import com.mg.application.user.service.UserService;
import com.mg.application.user.util.Get_bean;
import com.mg.application.user.util.Get_json;

@Controller
public class Usercontroller {
	@Resource(name="userService")
	private UserService userservice;
	//private String message;//用于返回结果的，比如说登录，就有登录成功，登录失败等。。
	//private boolean status;
	@RequestMapping(value="/login",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object sel_user(User user){
		User us = userservice.user_login(user);
		JSONObject json = (JSONObject) JSONObject.toJSON(us);
		if(us!=null){
			return Get_json.setjson(us,true,"登录成功");
		}
		return Get_json.setjson(null, false,"账号或者密码错误");
		//return JSON.toJSONString(json);
	}
	//更新用户
	@RequestMapping(value="upd_user",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object upd_user(Integer id,String username,String loginname,String password,Integer usertype,Integer sex,String phone,String email,Integer status,Integer authority){
		int i = userservice.upd_user(id, username, loginname, password, usertype, sex, phone, email, status,authority);
		if(i!=0){
			return Get_json.setjson(null,true,"更新成功");
		}
		return Get_json.setjson(null,false,"更新发生错误");
	}
	//删除用户
	@RequestMapping(value="/deluser",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object del_user(Integer id){
		int i = userservice.del_user(id);
		//return JSON.toJSONString("删除成功");
		if(i!=0){
			return Get_json.setjson(null,true,"删除成功");
		}
		return Get_json.setjson(null,false,"删除失败");
	}
	//查询用户
	@RequestMapping(value="/getuser",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object sle_user(@RequestParam(value="id",required=false)Integer id){
		List<User> li = userservice.sel_user(id);
		if(li!=null){
			return Get_json.setjson(li,true,"查询成功");
		}
		return Get_json.setjson(null,false,"更新失败");
	}
	/*private Integer id;
	private String username;//姓名
	private String loginname;//登录账户
	private String password;
	private Integer usertype;//账户类型（超级管理员1，普通操作员2）
	private Integer sex;//性别（男1，女0）
	private String phone;
	private String email;
	Integer id,
	String username,
	String loginmae,
	String password,
	Integer usertype,
	Integer sex,
	String phone,
	String email,
	Integer status*/
	//用户注册
	@RequestMapping(value="/adduser",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object adduser(User user){
		int i = userservice.add_user(user);
		if(i!=0){
			return Get_json.setjson(null,true,"增加用户成功");
		}
		return Get_json.setjson(null,false,"增加用户失败");
	}
	
	
}

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
	//private String message;//���ڷ��ؽ���ģ�����˵��¼�����е�¼�ɹ�����¼ʧ�ܵȡ���
	//private boolean status;
	@RequestMapping(value="/login",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object sel_user(User user){
		User us = userservice.user_login(user);
		JSONObject json = (JSONObject) JSONObject.toJSON(us);
		if(us!=null){
			return Get_json.setjson(us,true,"��¼�ɹ�");
		}
		return Get_json.setjson(null, false,"�˺Ż����������");
		//return JSON.toJSONString(json);
	}
	//�����û�
	@RequestMapping(value="upd_user",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object upd_user(Integer id,String username,String loginname,String password,Integer usertype,Integer sex,String phone,String email,Integer status,Integer authority){
		int i = userservice.upd_user(id, username, loginname, password, usertype, sex, phone, email, status,authority);
		if(i!=0){
			return Get_json.setjson(null,true,"���³ɹ�");
		}
		return Get_json.setjson(null,false,"���·�������");
	}
	//ɾ���û�
	@RequestMapping(value="/deluser",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object del_user(Integer id){
		int i = userservice.del_user(id);
		//return JSON.toJSONString("ɾ���ɹ�");
		if(i!=0){
			return Get_json.setjson(null,true,"ɾ���ɹ�");
		}
		return Get_json.setjson(null,false,"ɾ��ʧ��");
	}
	//��ѯ�û�
	@RequestMapping(value="/getuser",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object sle_user(@RequestParam(value="id",required=false)Integer id){
		List<User> li = userservice.sel_user(id);
		if(li!=null){
			return Get_json.setjson(li,true,"��ѯ�ɹ�");
		}
		return Get_json.setjson(null,false,"����ʧ��");
	}
	/*private Integer id;
	private String username;//����
	private String loginname;//��¼�˻�
	private String password;
	private Integer usertype;//�˻����ͣ���������Ա1����ͨ����Ա2��
	private Integer sex;//�Ա���1��Ů0��
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
	//�û�ע��
	@RequestMapping(value="/adduser",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public Object adduser(User user){
		int i = userservice.add_user(user);
		if(i!=0){
			return Get_json.setjson(null,true,"�����û��ɹ�");
		}
		return Get_json.setjson(null,false,"�����û�ʧ��");
	}
	
	
}

package com.mg.application.user.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.mg.application.equipment.entity.Equipment;
import com.mg.application.organize.entity.Organize;
import com.mg.application.user.entity.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public  class Get_json {
	private static JSONObject json;
	public static Object setjson(Object obj,boolean status,String message){
		json = new JSONObject();
		if(obj!=null){
			json.put("data",obj);
		}
		json.put("status",status);
		json.put("message", message);
		return json.toString();
	}
	
	public static <T> Object setjson(List<T> li,List<T> lie,boolean status,String message){
		json = new JSONObject();
		
			/*JSON jd = (JSON) json.put("organize",lij);
			JSON sb = (JSON) json.put("equipment", lis);
			json.put("data", jd);*/
			 Map<String , List<T>> stu = new HashMap<String, List<T>>();
			stu.put("organize",li);
			stu.put("equipment",lie);
			json.put("data",stu);
			json.put("status",status);
			json.put("message",message);
		return json.toString();
		//return null;
	}
}
/*List<User> li = userservice.sel_user(id);
JSONArray jsonArray = JSONArray.fromObject(li);
return jsonArray.toString();*/
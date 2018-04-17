package com.mg.application.test;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.sf.json.JSONArray;




import com.mg.application.organize.entity.Organize;
import com.mg.application.organize.service.OrganizeService;
import com.mg.application.user.entity.User;
import com.mg.application.user.service.UserService;
import com.mg.application.user.util.Get_bean;

public class UserloginTest {

	@Test
	public void orgainzetest(){
		//System.out.println("dd");
		OrganizeService os = (OrganizeService) Get_bean.sel_bean("organizeService");
		List<Organize> li = new ArrayList<Organize>();
		li = os.sel_organize(2);
		//JSONObject json = JSONObject.toJSON(li);
		//System.out.println(li.get(0).getEqli().size()+"dd");
		JSONArray jsonArray = JSONArray.fromObject(li);
		System.out.println(jsonArray.toString());
	}
	@Test
	public void testusers(){
		UserService os = (UserService) Get_bean.sel_bean("userService");
		User user = new User();
		user.setLoginname("admin");
		user.setPassword("123456");
		User s = os.user_login(user);
		//System.out.println(s);
		JSONArray jsonArray = JSONArray.fromObject(s);
		System.out.println(jsonArray.toString());
	}
}

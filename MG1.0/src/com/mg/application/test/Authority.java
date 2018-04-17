package com.mg.application.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.mg.application.authority.entity.ZuAuthority;
import com.mg.application.authority.service.AuthorityService;
import com.mg.application.equipmentauthority.entity.EquipmentAuthority;
import com.mg.application.equipmentauthority.service.EquipmentAuthorityService;
import com.mg.application.menuauthority.service.MenuAuthorityService;
import com.mg.application.organizeauthority.entity.Organizeauthority;
import com.mg.application.organizeauthority.service.OrganizeAuthorityService;
import com.mg.application.user.util.Get_bean;
import com.mg.application.user.util.Get_json;

public class Authority {
	/*
	 * 权限测试的
	 * 
	 */
	//添加菜单权限 更新
	@Test
	public void add_menuauth(){
		MenuAuthorityService ms = (MenuAuthorityService) Get_bean.sel_bean("menuServiceImpl");
		//int cid[] ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		//ms.add_menuauth(13, cid, 0);
		/*int cid[] ={1,2,3,4,5,6,7,8,9};
		int status[] = {1,1,1,1,1,1,1,1,1};
		int i  = ms.upd_menuauth(13, cid, status);
		System.out.println(i);*/
		ms.del_menuauth(14);
	}
	//添加权限组
	@Test
	public void add_authority(){
		AuthorityService as = (AuthorityService) Get_bean.sel_bean("authorityService");
		OrganizeAuthorityService os = (OrganizeAuthorityService) Get_bean.sel_bean("organizeauthorityService");
		EquipmentAuthorityService es = (EquipmentAuthorityService) Get_bean.sel_bean("equipmentAuthorityService");
		ZuAuthority zuauto = new ZuAuthority();
		zuauto.setId(0);
		zuauto.setName("test4.9");
		//先添加权限组
				int i = as.add_authority(zuauto);
				if(i!=0){//如果添加权限组成功，就开始添加节点和设备了
					//ed.add_equipmentAuthority(equipmentau);
					//OrganizeAuthorityService os = (OrganizeAuthorityService) Get_bean.sel_bean("organizeauthorityService");
					os.add_organ(zuauto.getId());//批量添加节点权限
					es.add_sauth(zuauto.getId());//批量添加设备权限
				}
		//添加完权限组之后，再去批量更新节点权限和设备权限
				updeqs(zuauto.getId());//批量更新节点信息
				add_equipmentauthority(zuauto.getId());//批量更新设备信息
	}
	//添加设备权限
	//@Test
	public void add_equipmentauthority(Integer zid){
		EquipmentAuthorityService es = (EquipmentAuthorityService) Get_bean.sel_bean("equipmentAuthorityService");
		/*EquipmentAuthority eh = new EquipmentAuthority();
		eh.setEquipmentid(1);
		eh.setOrganizeid(9);
		eh.setStatus(0);
		es.add_equipmentAuthority(eh);*/
		//es.a
		//es.add_sauth(11);
		//更新
		int equipmentid[] ={1,2};
		int status[] = {1,1};
		es.upd_sauth(zid, equipmentid, status);
		//删除
		//es.del_sauth(13);
	}
	//添加节点权限
	@Test
	public void add_organizeauthority(){
		OrganizeAuthorityService os = (OrganizeAuthorityService) Get_bean.sel_bean("organizeauthorityService");
		EquipmentAuthorityService es = (EquipmentAuthorityService) Get_bean.sel_bean("equipmentAuthorityService");
	//	os.add_organ(6);
		//os.add_organizeauthority(1,1,0);
		//删除节点权限
		//os.del_organ(14);
		List<Organizeauthority> li = os.sel_authoritys(8, 13);//查询该节点下的哪些节点可以查看
		List<EquipmentAuthority> lis = es.sel_equipmentauthority(8, 14);
		JSONArray jsons = JSONArray.fromObject(lis);
		System.out.println(jsons.toString());
		JSONArray json = JSONArray.fromObject(li);
		System.out.println(json.toString());
		//Get_json.setjson(li, status, message)
	}
	//查找权限
	@Test
	public void sel_authoritys(){
		AuthorityService as = (AuthorityService) Get_bean.sel_bean("authorityService");
		/*List<ZuAuthority> li = as.sel_authority(13);
		JSONArray json = JSONArray.fromObject(li);
		System.out.println(json.toString());*/
		//as.upd_authority("qwer", 13);
		//删除
		as.del_authority(13);
	}
	//批量导入设备
	public void addeq(){
		
	}
	//批量更新节点权限
	//@Test
	public void updeqs(Integer zid){
		OrganizeAuthorityService os = (OrganizeAuthorityService) Get_bean.sel_bean("organizeauthorityService");
		int j[] ={1,2,3,4};
		int status[] = {1,1,1,1};
		int i = os.upd_organ(zid, j , status);
		System.out.println(i);
	}
	@Test
    public void WriteStringToFile() {  
        try {  
            File file = new File("D:/1.txt");  
            PrintStream ps = new PrintStream(new FileOutputStream(file));  
            ps.println("http://www.jb51.net");// 往文件里写入字符串  
            ps.append("http://www.jb51.net");// 在已有的基础上添加字符串  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }
	@Test
    public void readString4()  
    
    {  
  
        int len=0;  
  
        StringBuffer str=new StringBuffer("");  
  
        File file=new File("D:/prog_index.m3u8");  
  
        try {  
  
            FileInputStream is=new FileInputStream(file);  
  
            InputStreamReader isr= new InputStreamReader(is);  
  
            BufferedReader in= new BufferedReader(isr);  
  
            String line=null;  
  
            while( (line=in.readLine())!=null )  
            {  
                if(len != 0)  // 处理换行符的问题  
                {  
                    str.append("\r\n"+line);  
                }  else  
                {  
  
                    str.append(line);  
  
                }  
  
                len++;  
  
            }  
            in.close();  
            is.close();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
       System.out.println(str.toString());  
    }  
}

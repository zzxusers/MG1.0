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
	 * Ȩ�޲��Ե�
	 * 
	 */
	//��Ӳ˵�Ȩ�� ����
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
	//���Ȩ����
	@Test
	public void add_authority(){
		AuthorityService as = (AuthorityService) Get_bean.sel_bean("authorityService");
		OrganizeAuthorityService os = (OrganizeAuthorityService) Get_bean.sel_bean("organizeauthorityService");
		EquipmentAuthorityService es = (EquipmentAuthorityService) Get_bean.sel_bean("equipmentAuthorityService");
		ZuAuthority zuauto = new ZuAuthority();
		zuauto.setId(0);
		zuauto.setName("test4.9");
		//�����Ȩ����
				int i = as.add_authority(zuauto);
				if(i!=0){//������Ȩ����ɹ����Ϳ�ʼ��ӽڵ���豸��
					//ed.add_equipmentAuthority(equipmentau);
					//OrganizeAuthorityService os = (OrganizeAuthorityService) Get_bean.sel_bean("organizeauthorityService");
					os.add_organ(zuauto.getId());//������ӽڵ�Ȩ��
					es.add_sauth(zuauto.getId());//��������豸Ȩ��
				}
		//�����Ȩ����֮����ȥ�������½ڵ�Ȩ�޺��豸Ȩ��
				updeqs(zuauto.getId());//�������½ڵ���Ϣ
				add_equipmentauthority(zuauto.getId());//���������豸��Ϣ
	}
	//����豸Ȩ��
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
		//����
		int equipmentid[] ={1,2};
		int status[] = {1,1};
		es.upd_sauth(zid, equipmentid, status);
		//ɾ��
		//es.del_sauth(13);
	}
	//��ӽڵ�Ȩ��
	@Test
	public void add_organizeauthority(){
		OrganizeAuthorityService os = (OrganizeAuthorityService) Get_bean.sel_bean("organizeauthorityService");
		EquipmentAuthorityService es = (EquipmentAuthorityService) Get_bean.sel_bean("equipmentAuthorityService");
	//	os.add_organ(6);
		//os.add_organizeauthority(1,1,0);
		//ɾ���ڵ�Ȩ��
		//os.del_organ(14);
		List<Organizeauthority> li = os.sel_authoritys(8, 13);//��ѯ�ýڵ��µ���Щ�ڵ���Բ鿴
		List<EquipmentAuthority> lis = es.sel_equipmentauthority(8, 14);
		JSONArray jsons = JSONArray.fromObject(lis);
		System.out.println(jsons.toString());
		JSONArray json = JSONArray.fromObject(li);
		System.out.println(json.toString());
		//Get_json.setjson(li, status, message)
	}
	//����Ȩ��
	@Test
	public void sel_authoritys(){
		AuthorityService as = (AuthorityService) Get_bean.sel_bean("authorityService");
		/*List<ZuAuthority> li = as.sel_authority(13);
		JSONArray json = JSONArray.fromObject(li);
		System.out.println(json.toString());*/
		//as.upd_authority("qwer", 13);
		//ɾ��
		as.del_authority(13);
	}
	//���������豸
	public void addeq(){
		
	}
	//�������½ڵ�Ȩ��
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
            ps.println("http://www.jb51.net");// ���ļ���д���ַ���  
            ps.append("http://www.jb51.net");// �����еĻ���������ַ���  
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
                if(len != 0)  // �����з�������  
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

package com.mg.application.test;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.mg.application.equipment.entity.Equipment;
import com.mg.application.equipment.service.EquipmentService;
import com.mg.application.user.util.Get_bean;

public class EquipmentTest {
	private EquipmentService os = (EquipmentService) Get_bean.sel_bean("equipmentService");
	@Test
	public  void addeq(){
		
		/*private Integer id;// 编号
		private Integer joins;// 连接方式
		private Integer equipmenttype;// 设备类型
		private String equipmentname;// 设备名称
		private Integer shop;// 厂家
		private String equipmentversion;// 设备型号
		private String ip;// IP地址
		private Integer ports;// 端口
		private String loginname;// 账户
		private String loginpaws;// 密码
		private Integer orgznizeid;// 组织结构
		private Integer pas_scount;// 通道数
		private Integer pass_type;// 通道类型
		private String txt;// 描述说明
	*/
		Equipment eq = new Equipment();
		eq.setId(0);
		eq.setJoins(1);
		eq.setEquipmenttype(1);
		eq.setEquipmentname("dd");
		eq.setShop(1);
		eq.setEquipmentversion("123");
		eq.setIp("adf");
		eq.setPorts(123);
		eq.setLoginname("admin");
		eq.setLoginpaws("123");
		eq.setOrganizeid(1);
		eq.setPass_count(1);
		eq.setPass_type(1);
		eq.setTxt("test1");
		int i = os.add_equipment(eq);
		System.out.println(i);
	}
	@Test
	public void del_test(){
		Integer[] is = new Integer[8];
		is[0]=5;
		is[1]=6;
		int i = os.del_equipment(is);
		System.out.println(i);
	}
	/*Integer id,
	Integer joins,
	Integer equipmenttype,
	String equipmentname,
	Integer shop,
	String equipmentversion,
	String ip,
	Integer ports,
	String loginname,
	String loginpaws,
	Integer orgznizeid,
	Integer pass_count,
	Integer pass_type,
	String txt*/
	@Test
	public void upd_test(){
		os.upd_equipment(5,2,2, "zzx",1, "1.1", "123.123.123.123", 1, "zzx", "zxx", 2,1,3,"666");
	}
	@Test
	public void sel_test(){
		List<Equipment> li = os.sel_quipment(null,null,null,null,7);
		
		JSONArray json = JSONArray.fromObject(li);
		System.out.println(json.toString());
	}
	@Test
	public void jsontest(){
		int taskid = 192;  
        String tableName = "tablename";  
  
        JSONObject jsonStatus = new JSONObject();  
        jsonStatus.put("code", 0);  
        jsonStatus.put("msg", "succ");  
        // ===========================  
        JSONObject jsonData = new JSONObject();  
        jsonData.put("taskid", taskid);  
        jsonData.put("tableName", tableName);  
        // ===========================  
        JSONObject objData = new JSONObject();  
        objData.put("status", jsonStatus);  
        objData.put("data", jsonData);  
  
        System.out.println(objData.toString());  
	}
}

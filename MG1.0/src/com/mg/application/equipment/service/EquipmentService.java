package com.mg.application.equipment.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mg.application.equipment.entity.Equipment;

public interface EquipmentService {

	/*private Integer id;// ���
	private Integer joins;// ���ӷ�ʽ
	private Integer equipmenttype;// �豸����
	private String equipmentname;// �豸����
	private Integer shop;// ����
	private String equipmentversion;// �豸�ͺ�
	private String ip;// IP��ַ
	private Integer ports;// �˿�
	private String loginname;// �˻�
	private String loginpaws;// ����
	private Integer orgznizeid;// ��֯�ṹ
	private Integer pas_scount;// ͨ����
	private Integer pass_type;// ͨ������
	private String txt;// ����˵��
*/	//����豸
	public int add_equipment(Equipment eq); 
	//ɾ���豸
	public int del_equipment(Integer id[]);
	//����
	public int upd_equipment(Integer id,Integer joins,Integer equipmenttype,
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
							String txt
			
			);
	//�����豸
	public List<Equipment> sel_quipment(@Param("id")Integer id,@Param("equipmentname")String equipmentname,@Param("organizename")String organizename,@Param("currentpage")Integer currentpage,@Param("organizeid")Integer organizeid);
	//public int add_sauth();

}

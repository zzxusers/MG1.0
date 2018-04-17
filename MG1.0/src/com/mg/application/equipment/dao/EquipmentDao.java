package com.mg.application.equipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.equipment.entity.Equipment;
import com.mg.application.equipmentauthority.entity.EquipmentAuthority;

/*
 * �豸����ӿ�
 */
@Repository("equipmentDao")
public interface EquipmentDao {
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
	public int add_equipment(@Param("eq")Equipment eq,@Param("equipmentau")List<EquipmentAuthority> equipmentau); 
	//ɾ���豸��ͬʱ��Ҫ����ɾ���豸Ȩ��������ݣ�
	public int del_equipment(@Param("id")Integer id);
	//����
	public int upd_equipment(@Param("id")Integer id,@Param("joins")Integer joins,@Param("equipmenttype")Integer equipmenttype,
							@Param("equipmentname")String equipmentname,
							@Param("shop")Integer shop,
							@Param("equipmentversion")String equipmentversion,
							@Param("ip")String ip,
							@Param("ports")Integer ports,
							@Param("loginname")String loginname,
							@Param("loginpaws")String loginpaws,
							@Param("orgznizeid")Integer orgznizeid,
							@Param("pass_count")Integer pass_count,
							@Param("pass_type")Integer pass_type,
							@Param("txt")String txt
			
			);
	//�����豸,���Ը���id��ѯ����֯�ṹ��ѯ���豸���Ʋ�ѯ,currentpage��ǰҳ�룬�״ν���Ĭ��Ϊ0 
	public List<Equipment> sel_quipment(@Param("id")Integer id,@Param("equipmentname")String equipmentname,@Param("organizename")String organizename,@Param("currentpage")Integer currentpage,@Param("organizeid")Integer organizeid);
	//���������豸Ȩ��
	// INSERT INTO s_authority (organizeid,equipmentid) SELECT orgznizeid,id FROM equipment;
	//public int add_sauth();
	
}

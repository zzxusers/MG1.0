package com.mg.application.equipment.entity;

public class Equipment {
	/*
	 * create table equipment( id int(10) primary key auto_increment, joins
	 * int(2) not null, equipmenttype int(2) not null, equipmentname varchar(40)
	 * not null, shop int(2) not null, equipmentversion varchar(40), ip
	 * varchar(30) not null, ports int(10), loginname varchar(20), loginpaws
	 * varchar(20), orgznizeid int(5) not null, pas_scount int(2) not null,
	 * pass_type int(2) not null, txt varchar(100) );
	 */
	// �豸entity
	private Integer id;// ���
	private Integer joins;// ���ӷ�ʽ
	private Integer equipmenttype;// �豸����
	private String equipmentname;// �豸����
	private Integer shop;// ����
	private String equipmentversion;// �豸�ͺ�
	private String ip;// IP��ַ
	private Integer ports;// �˿�
	private String loginname;// �˻�
	private String loginpaws;// ����
	private Integer organizeid;// ��֯�ṹ
	private String organizename;//��֯����
	private Integer currentpage;//��ǰҳ��
	private Integer pagecount;//��ҳ��
	
	public Integer getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(Integer currentpage) {
		this.currentpage = currentpage;
	}

	public Integer getPagecount() {
		return pagecount;
	}

	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}

	public String getOrganizename() {
		return organizename;
	}

	public void setOrganizename(String organizename) {
		this.organizename = organizename;
	}

	private Integer pass_count;// ͨ����
	private Integer pass_type;// ͨ������
	private String txt;// ����˵��

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJoins() {
		return joins;
	}

	public void setJoins(Integer joins) {
		this.joins = joins;
	}

	public Integer getEquipmenttype() {
		return equipmenttype;
	}

	public void setEquipmenttype(Integer equipmenttype) {
		this.equipmenttype = equipmenttype;
	}

	public String getEquipmentname() {
		return equipmentname;
	}

	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}

	public Integer getShop() {
		return shop;
	}

	public void setShop(Integer shop) {
		this.shop = shop;
	}

	public String getEquipmentversion() {
		return equipmentversion;
	}

	public void setEquipmentversion(String equipmentversion) {
		this.equipmentversion = equipmentversion;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPorts() {
		return ports;
	}

	public void setPorts(Integer ports) {
		this.ports = ports;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpaws() {
		return loginpaws;
	}

	public void setLoginpaws(String loginpaws) {
		this.loginpaws = loginpaws;
	}

	public Integer getOrganizeid() {
		return organizeid;
	}

	public void setOrganizeid(Integer orgznizeid) {
		this.organizeid = orgznizeid;
	}

	
	public Integer getPass_count() {
		return pass_count;
	}

	public void setPass_count(Integer pass_count) {
		this.pass_count = pass_count;
	}

	public Integer getPass_type() {
		return pass_type;
	}

	public void setPass_type(Integer pass_type) {
		this.pass_type = pass_type;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}
}

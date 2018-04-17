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
	// 设备entity
	private Integer id;// 编号
	private Integer joins;// 连接方式
	private Integer equipmenttype;// 设备类型
	private String equipmentname;// 设备名称
	private Integer shop;// 厂家
	private String equipmentversion;// 设备型号
	private String ip;// IP地址
	private Integer ports;// 端口
	private String loginname;// 账户
	private String loginpaws;// 密码
	private Integer organizeid;// 组织结构
	private String organizename;//组织名称
	private Integer currentpage;//当前页码
	private Integer pagecount;//总页码
	
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

	private Integer pass_count;// 通道数
	private Integer pass_type;// 通道类型
	private String txt;// 描述说明

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

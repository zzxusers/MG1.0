package com.mg.application.organize.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.organize.entity.Organize;
@Repository("organizeDao")
public interface OrganizeDao {
	//查找所选节点下的全部的子结构组织（比如：单击root后，要查询出root下面所有的子节点）
	public List<Organize> sel_organize(@Param("id")Integer id);
	//删除节点，删除节点将会删除该节点下面的所有的子节点和设备还会删除节点权限表的数据。
	public int del_organize(@Param("id")Integer id);
	//增加节点
	public int add_organize(@Param("organize")Organize organize);
	//更新节点,fid是为了标记要添加到那个父节点下
	public int upd_organize(@Param("id")Integer id,@Param("organizename")String organizename);
}

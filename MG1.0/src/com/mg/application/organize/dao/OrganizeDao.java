package com.mg.application.organize.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mg.application.organize.entity.Organize;
@Repository("organizeDao")
public interface OrganizeDao {
	//������ѡ�ڵ��µ�ȫ�����ӽṹ��֯�����磺����root��Ҫ��ѯ��root�������е��ӽڵ㣩
	public List<Organize> sel_organize(@Param("id")Integer id);
	//ɾ���ڵ㣬ɾ���ڵ㽫��ɾ���ýڵ���������е��ӽڵ���豸����ɾ���ڵ�Ȩ�ޱ�����ݡ�
	public int del_organize(@Param("id")Integer id);
	//���ӽڵ�
	public int add_organize(@Param("organize")Organize organize);
	//���½ڵ�,fid��Ϊ�˱��Ҫ��ӵ��Ǹ����ڵ���
	public int upd_organize(@Param("id")Integer id,@Param("organizename")String organizename);
}

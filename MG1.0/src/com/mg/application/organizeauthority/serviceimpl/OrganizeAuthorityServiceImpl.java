package com.mg.application.organizeauthority.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mg.application.authority.entity.ZuAuthority;
import com.mg.application.authority.service.AuthorityService;
import com.mg.application.organizeauthority.dao.OrganizeAuthorityDao;
import com.mg.application.organizeauthority.entity.Organizeauthority;
import com.mg.application.organizeauthority.service.OrganizeAuthorityService;
@Service("organizeauthorityService")
public class OrganizeAuthorityServiceImpl implements OrganizeAuthorityService{
	@Resource(name="organizeAuthorityDao")
	private OrganizeAuthorityDao organizeautodao;
	@Resource(name="authorityService")
	private AuthorityService as;
	@Override
	public int add_organizeauthority(Integer zu_id,Integer j_id,Integer status) {
		// TODO Auto-generated method stub
		int i = organizeautodao.add_organizeauthority(zu_id,j_id,status);
		return i;
	}
	@Override
	public List<Organizeauthority> sel_orgauthority(Integer id) {
		// TODO Auto-generated method stub
		List<Organizeauthority> li = organizeautodao.sel_orgauthority(id);//根据传入的权限组的id，来查询出该id下有哪些节点可以被查看
		return li;
	}
	@Override
	public int add_organ(Integer id) {
		// TODO Auto-generated method stub
		int i = organizeautodao.add_organ(id);
		return i;
	}
	//批量更新节点操作
	@Override
	public int upd_organ(Integer zu_id, int[] j, int[] status) {
		// TODO Auto-generated method stub
		List<Organizeauthority> li = new ArrayList<Organizeauthority>();
		//将传进来的数组封装成一个list集合
		for(int i = 0;i<=j.length-1;i++){
			Organizeauthority ot = new Organizeauthority();
			ot.setIdj(zu_id);
			ot.setOrganizeid(j[i]);
			ot.setStatus(status[i]);
			li.add(ot);
		}
		 Map<String,Object> param = new HashMap<String,Object>();
		 param.put("list",li);
		int s = organizeautodao.upd_organ(li);
		return s;
	}
	@Override
	public int del_organ(Integer zu_id) {
		// TODO Auto-generated method stub
		int i = organizeautodao.del_organ(zu_id);
		return i;
	}
	@Override
	public List<Organizeauthority> sel_authoritys(Integer jid, Integer zu_id) {
		// TODO Auto-generated method stub
		List<Organizeauthority> li = organizeautodao.sel_authoritys(jid, zu_id);
		return li;
	}
	//添加节点的时候同时还要添加节点权限
	/*zu_id   权限组的id数组
	 * (non-Javadoc)
	 * @see com.mg.application.organizeauthority.service.OrganizeAuthorityService#add_organzu(int[], java.lang.Integer)
	 */
	@Override
	public int add_organzu(Integer jid) {
		// TODO Auto-generated method stub
		List<ZuAuthority> liz = as.sel_authority(null);
		List<Organizeauthority> lio =new ArrayList<Organizeauthority>();
		for(int i = 0 ;i<=liz.size()-1;i++){
			Organizeauthority o = new Organizeauthority();
			o.setIdj(liz.get(i).getId());
			o.setOrganizeid(jid);
			lio.add(o);
		}
		int s = organizeautodao.add_organzu(lio);
		return s;
	}
	

}

package cn.com.qxl.shiro.dao;

import java.util.List;

import cn.com.cibtc.database.dao.impl.MybatisDao;
import cn.com.qxl.shiro.enums.FieldSysPerm;
import cn.com.qxl.shiro.model.SysPerm;

public interface IResourceDao extends MybatisDao<FieldSysPerm, SysPerm, Long> {
	
	public List<SysPerm> listResource();
	

}

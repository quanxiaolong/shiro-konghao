package cn.com.qxl.shiro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.cibtc.database.dao.impl.MybatisDao;
import cn.com.qxl.shiro.enums.FieldSysUsers;
import cn.com.qxl.shiro.model.SysPerm;
import cn.com.qxl.shiro.model.SysUsers;

public interface IUserDao extends MybatisDao<FieldSysUsers, SysUsers, Long> {

	public List<SysUsers> listUser();
	
	public SysUsers loadByUserName(@Param("userName")String userName);
	
	public List<SysUsers> listByRole(@Param("roleId") Long roleId);
	
	public List<SysPerm> listAllResource(@Param("userId")Long userId);
	
}

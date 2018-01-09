package cn.com.qxl.shiro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.cibtc.database.dao.impl.MybatisDao;
import cn.com.qxl.shiro.enums.FieldSysRoles;
import cn.com.qxl.shiro.model.SysPerm;
import cn.com.qxl.shiro.model.SysRoles;
import cn.com.qxl.shiro.model.SysRolesPerm;
import cn.com.qxl.shiro.model.SysUsersRoles;

public interface IRoleDao extends MybatisDao<FieldSysRoles, SysRoles, Long>{

	public List<SysRoles> listRole();
	
	public List<SysRoles> listUserRole(@Param("userId")Long userId);
	
	public SysUsersRoles loadUserRole(@Param("userId")Long userId,@Param("roleId")Long roleId);
	
	public void addUserRole (@Param("userId")Long userId,@Param("roleId")Long roleId);
	
	public void deleteUserRole(@Param("userId")Long userId,@Param("roleId")Long roleId);
	
	/**
	 * 删除某个用户的所有角色
	 * @param userId
	 */
	public void deleteUserRoles(@Param("userId")Long userId);
	
	/**
	 * 根据角色ID获取可访问的所有资源
	 * @param roleId
	 * @return
	 */
	public List<SysPerm> listRoleResource(@Param("roleId")Long roleId);
	
	public void addRoleResource(@Param("roleId")Long roleId,@Param("resId")Long resId);
	
	public void deleteRoleResource(@Param("roleId")Long roleId,@Param("resId")Long resId);
	
	public SysRolesPerm loadResourceRole(@Param("roleId")Long roleId,@Param("resId")int resId);
}

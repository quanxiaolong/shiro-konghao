package cn.com.qxl.shiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qxl.shiro.dao.IRoleDao;
import cn.com.qxl.shiro.model.SysPerm;
import cn.com.qxl.shiro.model.SysRoles;
import cn.com.qxl.shiro.model.SysRolesPerm;
import cn.com.qxl.shiro.model.SysUsersRoles;

@Service("roleService")
public class RoleService implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao;

	public void add(SysRoles role) {
		roleDao.insert(role);

	}

	public void delete(Long id) {
		roleDao.deleteById(id);
	}

	public SysRoles load(Long id) {
		
		return roleDao.searchById(id);
	}

	public List<SysRoles> list() {
		return roleDao.listRole();
	}

	public void update(SysRoles role) {
		// TODO Auto-generated method stub

	}

	public List<SysRoles> listUserRole(Long userId) {
		return roleDao.listUserRole(userId);
	}

	public SysUsersRoles loadUserRole(Long userId, Long roleId) {
		return roleDao.loadUserRole(userId, roleId);
	}

	public void addUserRole(Long userId, Long roleId) {
		roleDao.addUserRole(userId, roleId);
	}

	public void deleteUserRole(Long userId, Long roleId) {
		roleDao.deleteUserRole(userId, roleId);

	}

	public void deleteUserRoles(Long userId) {
		roleDao.deleteUserRoles(userId);

	}

	public List<SysPerm> listRoleResource(Long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addRoleResource(Long roleId, Long resId) {
		// TODO Auto-generated method stub

	}

	public void deleteRoleResource(Long roleId, Long resId) {
		// TODO Auto-generated method stub

	}

	public SysRolesPerm loadResourceRole(Long roleId, int resId) {
		// TODO Auto-generated method stub
		return null;
	}

}

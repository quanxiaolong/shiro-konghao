package cn.com.qxl.shiro.service;

import java.util.List;
import java.util.Set;

import cn.com.qxl.shiro.model.SysPerm;
import cn.com.qxl.shiro.model.SysUsers;

public interface IUserService {

	public void add(SysUsers user);
	
	public void delete(Long id);
	
	public void update(SysUsers user);
	
	public SysUsers load(Long id);
	
	public SysUsers loadByUserName(String userName);
	
	public SysUsers login(String userName,String password);
	
	public List<SysUsers> list();
	
	public List<SysUsers> listByRole( Long roleId);
	
	public List<SysPerm> listAllResource(Long userId);
	
	public Set<String> listUserRole(Long userId);
}

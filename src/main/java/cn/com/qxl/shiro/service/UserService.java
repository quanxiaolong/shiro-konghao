package cn.com.qxl.shiro.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.qxl.shiro.dao.IRoleDao;
import cn.com.qxl.shiro.dao.IUserDao;
import cn.com.qxl.shiro.kit.ShiroKit;
import cn.com.qxl.shiro.model.SysPerm;
import cn.com.qxl.shiro.model.SysRoles;
import cn.com.qxl.shiro.model.SysUsers;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IRoleDao roleDao;
	
	public void add(SysUsers user) {
		if(ShiroKit.isEmpty(user.getUsername())||ShiroKit.isEmpty(user.getPassword())){
			throw new RuntimeException("用户名或者密码不能为空！ ");
		}
		userDao.insert(user);

	}

	public void delete(Long id) {
		userDao.deleteById(id);

	}

	public void update(SysUsers user) {
		// TODO Auto-generated method stub

	}

	public SysUsers load(Long id) {
		return userDao.searchById(id);
	}

	public SysUsers loadByUserName(String userName) {
		SysUsers u = userDao.loadByUserName(userName);
		
		return u;
	}
	
	public SysUsers login(String userName,String password){
		SysUsers u = userDao.loadByUserName(userName);
		if(u==null){
			throw new UnknownAccountException("用户名密码错误");
		}
		if(!u.getPassword().equals(ShiroKit.md5(password, userName))){
			
			throw new IncorrectCredentialsException("用户名或密码错误！");
		}
		if(u.getLocked()){
			throw new LockedAccountException("用户已经被锁定");
		}
		return u;
	}

	public List<SysUsers> list() {
		return userDao.listUser();
	}

	public List<SysUsers> listByRole(Long roleId) {
		return userDao.listByRole(roleId);
	}

	public List<SysPerm> listAllResource(Long userId) {
		return userDao.listAllResource(userId);
	}
	
	public Set<String> listUserRole(Long userId){
		List<SysRoles> listRoles=roleDao.listUserRole(userId);
		Set<String> listRoleName = new HashSet<String>();
		if(!CollectionUtils.isEmpty(listRoles)){
			for(SysRoles roleItem : listRoles){
				listRoleName.add(roleItem.getRole());
			}
		}
		return listRoleName;
	}

}

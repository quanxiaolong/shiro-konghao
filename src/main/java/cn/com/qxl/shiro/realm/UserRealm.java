package cn.com.qxl.shiro.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.web.context.ContextLoader;

import cn.com.qxl.shiro.model.SysPerm;
import cn.com.qxl.shiro.model.SysRoles;
import cn.com.qxl.shiro.model.SysUsers;
import cn.com.qxl.shiro.service.IRoleService;
import cn.com.qxl.shiro.service.IUserService;

public class UserRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection printcipals) {
		SysUsers user = (SysUsers)printcipals.getPrimaryPrincipal();
		Long userId = user.getId();
		System.out.println(user.getId()+user.getUsername());
		IUserService userService = (IUserService)ContextLoader.getCurrentWebApplicationContext().getBean("userService");
		//IRoleService roleService = (IRoleService)ContextLoader.getCurrentWebApplicationContext().getBean("roleService");
		Set<String> listRoles = userService.listUserRole(userId);
		List<SysPerm> listPerms = userService.listAllResource(userId);
		Set<String> permissions = new HashSet<String>();
		for(SysPerm perm:listPerms){
			permissions.add(perm.getUrl());
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(listRoles);
		info.setStringPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		IUserService userService = (IUserService)ContextLoader.getCurrentWebApplicationContext().getBean("userService");
		String username = token.getPrincipal().toString();
		String password = new String((char[])token.getCredentials());
		SysUsers user = userService.login(username, password);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		info.setCredentialsSalt(ByteSource.Util.bytes(username));
		return info;
	}

}

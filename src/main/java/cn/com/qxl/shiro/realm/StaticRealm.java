package cn.com.qxl.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.com.qxl.shiro.permission.MyPermission;

public class StaticRealm extends AuthorizingRealm {

	/**
	 * 用来判断授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole("r1");
		info.addRole("r2");
		
		info.addStringPermission("+user+*");
		info.addObjectPermission(new MyPermission("+topic+create"));
		info.addObjectPermission(new MyPermission("+topic+delete+1"));
		info.addObjectPermission(new WildcardPermission("test:*"));
		return info;
	}
	/**
	 * 用来判断认证 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=token.getPrincipal().toString();
		String password = new String((char[])token.getCredentials());
		if(!"kh".equals(userName))throw new UnknownAccountException("用户名错误");
		if(!"123".equals(password)) throw new IncorrectCredentialsException("密码错误");
		AuthenticationInfo info = new SimpleAuthenticationInfo("abc@qq.com", password, getName());
		return info;
	}

}

package cn.com.qxl.shiro.realm;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MapRealm implements Realm {
	
	private static Map<String, String> users ;
	
	static{
		users = new HashMap<String, String>();
		users.put("kh", "1213");
		users.put("laozhang", "123");
	}

	public String getName() {
		
		return "mapRealm";
	}

	public boolean supports(AuthenticationToken token) {
		// TODO Auto-generated method stub
		return token instanceof UsernamePasswordToken;
	}

	
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=token.getPrincipal().toString();
		String password = new String((char[])token.getCredentials());
		System.out.println(userName+","+password);
		if(!users.containsKey(userName))throw new UnknownAccountException("用户名错误");
		if(!password.equals(users.get(userName))) throw new IncorrectCredentialsException("密码错误");
		AuthenticationInfo info = new SimpleAuthenticationInfo(userName, password, getName());
		return info;
	}

}

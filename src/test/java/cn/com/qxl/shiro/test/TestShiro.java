package cn.com.qxl.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class TestShiro {

	@Test
	public void testBase(){
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager manager = factory.getInstance();
		SecurityUtils.setSecurityManager(manager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("kh", "123");
		
		try {
			subject.login(token);
			PrincipalCollection ps =subject.getPrincipals();
			System.out.println(ps.asList());
			System.out.println(ps.getRealmNames());
			System.out.println(subject.getPrincipal());
		} catch (UnknownAccountException e) {
			System.out.println("用户名不存在");
		}catch(IncorrectCredentialsException e){
			System.out.println("用户密码不存在");
		}
	}
}

package cn.com.qxl.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class TestEncode {

	@Test
	public void testEncode(){
		System.out.println(new Md5Hash("123","user").toHex());
	}
	private Subject login(String username,String password){
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager manager = factory.getInstance();
		SecurityUtils.setSecurityManager(manager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		
		try {
			subject.login(token);
			return subject;
		} catch (UnknownAccountException e) {
			System.out.println("用户名不存在");
		}catch(IncorrectCredentialsException e){
			System.out.println("用户密码不存在");
		}
		return null;
	}
	@Test
	public void testPasswordService(){
		DefaultPasswordService service = new DefaultPasswordService();
		String str =service.encryptPassword("123");
		String str1=service.encryptPassword("123");
		System.out.println(str.equals(str1));
		System.out.println(service.passwordsMatch("123", str));
	}
	@Test
	public void testPasswordTestRealm(){
		login("user","123");
	}
}

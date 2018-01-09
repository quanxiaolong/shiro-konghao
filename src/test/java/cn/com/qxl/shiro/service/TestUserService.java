package cn.com.qxl.shiro.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import cn.com.qxl.shiro.model.SysPerm;
import cn.com.qxl.shiro.model.SysUsers;


public class TestUserService extends AbstractTest{
	@Resource
	private IUserService userService;
	@Test
	public void load(){
		List<SysUsers> listUser=userService.list();
		System.out.println(listUser.size());
	}
	
	@Test
	public void listAllResource(){
		List<SysPerm> listSysPerm=userService.listAllResource(1L);
		System.out.println(listSysPerm.size());
	}
}

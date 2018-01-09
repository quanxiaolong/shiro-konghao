package cn.com.qxl.shiro.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import cn.com.qxl.shiro.model.SysRoles;

public class TestRoleService extends AbstractTest {

	@Resource
	private IRoleService roleService;
	@Test
	public void load(){
		List<SysRoles> listRole=roleService.list();
		System.out.println(listRole.size());
	}
}

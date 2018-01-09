package cn.com.qxl.shiro.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import cn.com.qxl.shiro.model.SysPerm;

public class TestResourceService extends AbstractTest{
	
	@Resource
	private IResourceService resourceService;
	
	@Test
	public void load(){
		List<SysPerm> listResource=resourceService.listResource();
		System.out.println(listResource.size());
	}

}

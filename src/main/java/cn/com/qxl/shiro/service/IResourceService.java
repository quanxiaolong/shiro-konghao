package cn.com.qxl.shiro.service;

import java.util.List;

import cn.com.qxl.shiro.model.SysPerm;

public interface IResourceService {

	public void add(SysPerm res);
	
	public void update (SysPerm res);
	
	public void delete(Long id);
	
	public SysPerm load(Long id);

	public List<SysPerm> listResource();
	
	
}

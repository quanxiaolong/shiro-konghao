package cn.com.qxl.shiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qxl.shiro.dao.IResourceDao;
import cn.com.qxl.shiro.model.SysPerm;

@Service("resourceService")
public class ResourceService implements IResourceService{
	
	@Autowired
	private IResourceDao resourceDao;

	public void add(SysPerm res) {
		resourceDao.insert(res);
		
	}

	public void update(SysPerm res) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Long id) {
		resourceDao.deleteById(id);
		
	}

	public SysPerm load(Long id) {
		return resourceDao.searchById(id);
	}

	public List<SysPerm> listResource() {
		return resourceDao.listResource();
	}

}

package cn.com.qxl.shiro.permission;

import org.apache.shiro.authz.Permission;

public class MyPermission implements Permission{
	
	private String resourceId;
	private String operator;
	private String instanceId;
	
	
	

	public String getResourceId() {
		return resourceId;
	}




	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}




	public String getOperator() {
		return operator;
	}




	public void setOperator(String operator) {
		this.operator = operator;
	}




	public String getInstanceId() {
		return instanceId;
	}




	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public MyPermission(){
		
	}

	public MyPermission(String permissionStr){
		String[] strs=permissionStr.split("\\+");
		if(strs.length>1){
			this.setResourceId(strs[1]);
		}
		if(this.getResourceId()==null||"".equals(this.getResourceId())){
			this.setResourceId("*");
		}
		if(strs.length>2){
			this.setOperator(strs[2]);
		}
		if(strs.length>3){
			this.setInstanceId(strs[3]);
		}
		if(this.getInstanceId()==null||"".equals(this.getInstanceId())){
			this.setInstanceId("*");
		}
	}
	
	
	
	@Override
	public String toString() {
		return "MyPermission [resourceId=" + resourceId + ", operator=" + operator + ", instanceId=" + instanceId + "]";
	}




	public boolean implies(Permission p) {
		if(!(p instanceof MyPermission)) return false;
		MyPermission mp = (MyPermission) p;
		if(!"*".equals(this.getResourceId())&&!mp.getResourceId().equals(this.getResourceId()))
			return false;
		if(!"*".equals(this.getOperator())&&!mp.getOperator().equals(this.getOperator()))
			return false;
		if(!"*".equals(this.getInstanceId())&&!mp.getInstanceId().equals(this.getInstanceId()))
			return false;
		return true;
	}

}

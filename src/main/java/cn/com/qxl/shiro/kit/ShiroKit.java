package cn.com.qxl.shiro.kit;

import org.apache.shiro.crypto.hash.Md5Hash;

public class ShiroKit {

	public static String md5(String password,String salt){
		
		String p=null;
		p =new Md5Hash(password, salt).toHex();
		return p;
	}
	
	public static boolean isEmpty(Object obj){
		if(obj ==null){
			
			return true;
		}
		if(obj instanceof String){
			return "".equals(obj);
		}
		return false;
	}
	
	public static void main(String[] args){
		System.out.println(md5("123", "zs"));
	}
}

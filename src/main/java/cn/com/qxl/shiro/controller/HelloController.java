package cn.com.qxl.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequiresAuthentication
	@RequiresRoles("ADMIN")
	@RequestMapping("/t1.html")
	public String hello(){
		return "jsp/annotation";
	}
}

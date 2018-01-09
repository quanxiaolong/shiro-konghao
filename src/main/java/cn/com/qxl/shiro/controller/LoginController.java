package cn.com.qxl.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.qxl.shiro.kit.ShiroKit;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping(value="/login.html",method=RequestMethod.GET)
	public String login(){
		
		return "jsp/login";
	}
	
	@RequestMapping(value="/login.html",method=RequestMethod.POST)
	public String login(String username,String password,ModelMap model){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		String emsg = null;
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			emsg = e.getMessage();
		}
		if(ShiroKit.isEmpty(emsg)){
			return "redirect:/admin/user/list";
		}else{
			model.put("emsg", emsg);
			return "jsp/login";
		}
	}
}

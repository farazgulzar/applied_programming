package com.applied.programing.faraz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.applied.programing.faraz.entity.vo.LoginVo;
import com.applied.programing.faraz.entity.vo.UserVo;
import com.applied.programing.faraz.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService LoginService;
	
	
	    @GetMapping("/")
	    public String greetingForm(Model model) {
	    	model.addAttribute("loginVo",new LoginVo()); 
	        return "loginform";
	    }

	    @PostMapping("/login")
	    public String greetingSubmit(@ModelAttribute LoginVo loginVo, Model model) {
	    	System.out.println("Login ID :: " + loginVo.getLoginId());
	    	System.out.println("Login ID :: " + loginVo.getPassword());

	    	UserVo userVo =LoginService.auth(loginVo);
	    	if (userVo != null) {
	    		model.addAttribute("userVo", userVo);
	    		return "userdetails";	
	    	} else {
	    		return "errorpage";
	    	}
	    }

}

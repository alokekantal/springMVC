package com.javatpoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld(HttpServletRequest request, HttpServletResponse response){
		if(request.getParameter("password").equals("123")){
			String message= "hello world";
			return new ModelAndView("hellopage", "message", message);
		}else{
			String message= "Invalid user name or password";
			return new ModelAndView("errorpage", "message", message);
		}
		
	}
}
package com.javatpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeWorldController {

	@RequestMapping("/welcome")
	public ModelAndView welcome(){
		String welcome = "WELCOME TO SPRING MVC!!";
		return new ModelAndView("welcomepage", "message", welcome);
	}
}

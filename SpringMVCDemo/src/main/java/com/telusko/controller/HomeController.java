package com.telusko.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller			// Multi action controller
public class HomeController 
{
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("add")
	public ModelAndView add(@RequestParam("t1") int num1,@RequestParam("t2") int num2)
	{
	
		int result = num1 + num2;
		ModelAndView mv = new ModelAndView();
		mv.addObject("result",result);
		mv.setViewName("result.jsp");
		
		
		return mv;
	}
}


// something-servlet.xml
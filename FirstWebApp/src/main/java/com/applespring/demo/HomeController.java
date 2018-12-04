package com.applespring.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Alien;

@Controller
public class HomeController 
{
	@ModelAttribute("alien5")
	public Alien getAlien()
	{
		Alien alien = new Alien();
		alien.setAid(101);
		alien.setAname("A");
		alien.setAge(20);
		
		return alien;
	}
	
	@RequestMapping("/")
	public String home(Model m)
	{
		Alien a = new Alien();
		a.setAid(10);
		a.setAname("Navin");
		a.setAge(20);
		
		m.addAttribute("alien",a);
		
		return "home";
	}
	
	@PostMapping("add")
	public ModelAndView add(@RequestParam("t1") int num1,@RequestParam("t2") int num2, ModelAndView mv)
	{
	
		int result = num1 + num2;
		
		mv.addObject("result",result);
		mv.setViewName("result");
		
		
		return mv;
	}
	@GetMapping("divide")
	public ModelAndView divide(@RequestParam("t1") int num1,@RequestParam("t2") int num2, ModelAndView mv)
	{
	
		int result = num1 / num2;
		
		mv.addObject("result",result);
		mv.setViewName("result");
		
		
		return mv;
	}
	
	
	@PostMapping("addAlien")
	public ModelAndView addAlien(@ModelAttribute("alien1") Alien alien)
	{
		ModelAndView mv = new ModelAndView("result");
		
		return mv;
	}
}

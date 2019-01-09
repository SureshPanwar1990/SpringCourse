package com.applespring.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
//
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.applespring.demo.model.Alien;
import com.applespring.demo.repo.AlienRepository;

@Controller
public class HomeController 
{
	@Autowired
	AlienRepository repo;
	
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
	@GetMapping("getAlien")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		
		ModelAndView mv = new ModelAndView("result");
		
		Alien a1 = new Alien();
		a1.setAid(aid);
		a1.setAname("Kishor");
		a1.setAge(45);
		mv.addObject("result",a1);

		return mv;
	}
	@GetMapping("getAliens")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView getAliens()
	{
		ModelAndView mv = new ModelAndView("result");
		mv.addObject("result",repo.findAll());
		return mv;
	}
	
	
}

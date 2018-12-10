package com.applespring.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Alien;

@RestController
public class AlienController 
{
	@RequestMapping(value="aliens")
	public List<Alien> getAliens()
	{
	
		List<Alien> aliens = Arrays.asList(new Alien(101,"Navin",29),new Alien(102,"Vinoth",26));
		System.out.println("in alien con");
		
		return aliens;		

		
	}
	
	@GetMapping("alien/{aid}")
	public Alien getAlien(@PathVariable int aid)
	{
		
		return new Alien(102,"Vinoth",26);		

		
	}
	
	@PostMapping(value="aliens")
	public Alien addAlien(@ModelAttribute("alien1") Alien alien)
	{
		return alien;
	}
	
}

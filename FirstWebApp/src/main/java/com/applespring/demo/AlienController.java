package com.applespring.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.applespring.demo.model.Alien;
import com.applespring.demo.repo.AlienRepository;

@RestController
public class AlienController 
{
	@Autowired
	AlienRepository repo;
	
	@RequestMapping(value="aliens")
	public List<Alien> getAliens()
	{
	
		List<Alien> aliens = (List<Alien>) repo.findAll();
		System.out.println("in alien con");
		
		return aliens;		

		
	}
	
	@GetMapping("alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable int aid)
	{
		return repo.findById(aid);
	}
	
	@PostMapping(value="alien")
	public Alien addAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
}

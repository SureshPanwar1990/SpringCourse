package com.applespring.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.applespring.demo.model.Alien;
import com.applespring.demo.repo.AlienRepository;

//@RestController
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
	
	@RequestMapping(value="aliens/age/{age}")
	public List<Alien> getAliensByAge(@PathVariable int age)
	{
	
		List<Alien> aliens = (List<Alien>) repo.getByAgeGreaterThan(24);
		System.out.println("in alien con");
		
		return aliens;		
		
	}
	
	@GetMapping("alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable int aid)
	{
		System.out.println("in get alien");
		return repo.findById(aid);
	}
	
	@PostMapping(value="alien")
	@ResponseStatus(HttpStatus.CREATED)
	public Alien addAlien(@RequestBody Alien alien)
	{
		if(alien.getAge()<25)
			throw new ArithmeticException("Age should be more than 25");
			
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("alien/{aid}")
	public void deleteAlien(@PathVariable int aid)
	{
		repo.deleteById(aid);
	}
	
	@PutMapping("alien")
	public Alien updateAlien(@RequestBody Alien alien)
	{
		if(repo.existsById(alien.getAid()))
			repo.save(alien);
		return alien;
	}
	
	@ExceptionHandler(ArithmeticException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleArithmeticException(Exception e, HttpStatus status)
	{
		System.out.println("Something went wrong........");
		ErrorResponse res = new ErrorResponse(status, status.name(), e.getMessage());
		return res;
		
	}
}














// Main concerns
// side concerns






// Cross Cutting Concerns
// AOP -> Aspect Oriented Programming












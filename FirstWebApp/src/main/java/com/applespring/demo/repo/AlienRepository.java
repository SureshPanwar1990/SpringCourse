package com.applespring.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.applespring.demo.model.Alien;

public interface AlienRepository extends CrudRepository<Alien, Integer>
{
	
}

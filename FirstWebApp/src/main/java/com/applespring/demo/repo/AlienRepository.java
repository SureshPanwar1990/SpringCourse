package com.applespring.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.applespring.demo.model.Alien;

public interface AlienRepository extends JpaRepository<Alien, Integer>
{
	// DSL -> Domain Specific Lang
	@Query(value="select * from alien where age > ?",nativeQuery=true)
	List<Alien> getByAgeGreaterThan(int age);
	List<Alien> getByAnameLike(String n);
	
	
	
	
}

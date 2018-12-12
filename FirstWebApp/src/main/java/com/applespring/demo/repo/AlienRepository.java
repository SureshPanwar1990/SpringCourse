package com.applespring.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.applespring.demo.model.Alien;

public interface AlienRepository extends JpaRepository<Alien, Integer>
{
	// DSL -> Domain Specific Lang
	List<Alien> getByAgeGreaterThan(int age1);
}

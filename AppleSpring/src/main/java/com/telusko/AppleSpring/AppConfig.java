package com.telusko.AppleSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class AppConfig 
{
	@Bean
	@Scope("prototype")
	public Car getCar()
	{
		Car c = new Car();
		return c;
	}
	
	
	@Bean
	public Radio getRadio()
	{
		return new Radio();
	}
}
// Convention over configuration
package com.telusko.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@ComponentScan("com.telusko.controller")
@EnableWebMvc
@Configuration
public class MvcConfig
{
	
}

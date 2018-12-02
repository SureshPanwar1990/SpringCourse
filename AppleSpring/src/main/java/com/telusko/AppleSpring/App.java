package com.telusko.AppleSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();		// Container
    	context.scan("com.telusko.AppleSpring");
    	context.refresh();
    	
    	Car c1 = (Car) context.getBean(Car.class);			// Dependency Injection
        c1.drive();
        
       
    }
}

package com.telusko.AppleSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext navin = new ClassPathXmlApplicationContext("Spring.xml");		// Container
        Car c1 = (Car) navin.getBean("abc");			// Dependency Injection
        c1.drive();
        
       
    }
}

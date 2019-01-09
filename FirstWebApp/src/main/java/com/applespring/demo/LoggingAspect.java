package com.applespring.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.applespring.demo.AlienController.*(*))")
	public void beforeLog(JoinPoint jp)
	{
		String str = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		LOGGER.info("Method Called..." + str + " : " + args[0]);
	}
	
	@AfterReturning(pointcut="execution(public * com.applespring.demo.AlienController.*(*))", returning="returnValue")
	public void afterReturingLog(JoinPoint jp, Object returnValue)
	{
		String str = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		LOGGER.info("Method Called..." + str + " : " + returnValue);
	}
	
	@AfterThrowing(pointcut="execution(public * com.applespring.demo.AlienController.*(*))",throwing="e")
	public void afterThrowingLog(Exception e)
	{
		
		LOGGER.info( e.getMessage());
	}
	
	@Around("execution(public * com.applespring.demo.AlienController.*(*))")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable
	{
		LOGGER.info("before proceed");
		long startTime = System.currentTimeMillis();
		Object returnValue = jp.proceed();
		long totalTime = System.currentTimeMillis() - startTime;
		
		LOGGER.info("Total time : " + totalTime);
		
		return returnValue;
	}
	
	
}



// Before , after
// After(Finally) , AfterThrowing, AfterReturing

//, around
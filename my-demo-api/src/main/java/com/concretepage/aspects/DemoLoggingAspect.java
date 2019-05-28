package com.concretepage.aspects;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

						// not logging. why?
@Aspect			//Proxy service
@Component
public class DemoLoggingAspect {
	
	@Before("execution(public String getName())")
	public void getNameAdvice(){
		System.out.println("\n ......Executing Advice on getName()..... \n");
	}
/*	
	static Logger myLogger = Logger.getLogger(DemoLoggingAspect.class.getName());
	
	@Pointcut("execution(* com.concretepage.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.concretepage.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.concretepage.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
			// add advice to final pointcut expression	
	//@Before("forAppFlow()")
	@Before("execution(public List<Person> getPersonDetails())")			//pointcut expression
	public void beforeCallingMethods(JoinPoint jp) {
		
		System.out.println("/n..............before............../n");
		
		//display method we are calling
		String method= jp.getSignature().toShortString();
		myLogger.info("==>> calling method: "+method);
		
		//displaying arguments to method
		Object[] args= jp.getArgs();
		for(Object temp : args)
			myLogger.info("==>> method arguments : "+temp);
		
	}
		*/
}

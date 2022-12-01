package com.glarimy.domain;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class Logger {

	@Around("execution (* com.glarimy.domain.SimpleDirectory.*(..))")
	public Object log(ProceedingJoinPoint p) throws Throwable {
		System.out.println("Entering " + p.getSignature() + " with " + p.getArgs()[0]);
		Object result = p.proceed();
		System.out.println("Leaving  " + p.getSignature() + " with " + result);
		return result;
	}

}

package com.glarimy.domain;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MetricsCollector {

	@Around("execution (* com.glarimy.domain.SimpleDirectory.*(..))")
	public Object measure(ProceedingJoinPoint p) throws Throwable {
		long start = new Date().getTime();
		Object result = p.proceed();
		System.out.println(p.getSignature() + " is completed in " + (new Date().getTime() - start) + " ms");
		return result;
	}

}

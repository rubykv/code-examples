package com.example.aspect.config;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class SampleAspect {
	 Logger logger = LoggerFactory.getLogger(SampleAspect.class);
	
	@Pointcut("execution(* com.example.aspect.controller.SampleResource.*(..))")
	public void sample() {
		
	}
	
	@Before("sample()")
	public void beginTransaction(JoinPoint joinPoint) {
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		logger.info("Received call :: {} - {} - request param [{}]",request.getMethod(),request.getServletPath(),request.getParameter("name"));
	}

}

package com.cloud.support.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.cloud.jeesite.core.common.interceptor.BusinessAopInterceptor;


@Aspect
@Component
public class BusinessInterceptor extends BusinessAopInterceptor {
	@Override
	@Pointcut("execution(public * com.cloud.jeesite.*.modules..service.*.*(..)) && @annotation(org.springframework.transaction.annotation.Transactional)")
	protected void pointcut() {
	}
	
	@Override
	@Pointcut("execution(public * com.cloud.jeesite.*.modules..service.*.*(..))")
	protected void pointcutForThrowing() {
	}
}

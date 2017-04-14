package com.fuhj.log;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class ServiceLogAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		AppLogger.sysDebug("------------------------------------------------------------");
		StringBuffer buf1 = new StringBuffer();
		buf1.append("METHODBEFORE").append(" ");
		buf1.append(target.getClass().getName()).append(" ");
		buf1.append(method.getName()).append(" ");
		AppLogger.sysDebug(buf1.toString());
		StringBuffer buf2 = new StringBuffer("args: ");
		for (int i = 0; i < args.length; i++) {
			buf2.append("arg").append(i).append(" = ").append(args[i]).append(" ");
		}
		AppLogger.sysDebug(buf2.toString());
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		StringBuffer buf1 = new StringBuffer();
		buf1.append("AFTERRETURNING").append(" ");
		buf1.append(target.getClass().getName()).append(" ");
		buf1.append(method.getName()).append(" ");
		AppLogger.sysDebug(buf1.toString());
		StringBuffer buf2 = new StringBuffer("returnValue: ");
		buf2.append(returnValue);
		AppLogger.sysDebug(buf2.toString());
		AppLogger.sysDebug("------------------------------------------------------------");
	}
}

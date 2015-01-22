package com.inga.aop;


//@Aspect
//@Component
public class LogInterceptor {
//	@Pointcut("execution(public * com.inga..*.*(..))")
	public void myMethod() {};

//	@Before("myMethod()")
	public void before() {
		System.out.println("method start.");
	}
	
//	@After("myMethod()")
	public void after() {
		System.out.println("method after");
	}
}

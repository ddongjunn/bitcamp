package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAop {
	
	@Around("within(com.dto.*)") //이안에 있는 어떠한 메소드가 실행되면 이곳을 실행 
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureStr = joinPoint.getSignature().toShortString();
		
		System.out.println(signatureStr + " 시작");//실행전
	
		try {
			Object obj = joinPoint.proceed(); //실행시 
			
			return obj;
			
		}finally {
			System.out.println("실행 후:" + System.currentTimeMillis());
			System.out.println(signatureStr + " 종료");
		}
	}
}

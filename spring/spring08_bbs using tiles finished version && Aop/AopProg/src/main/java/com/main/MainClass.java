package com.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.Cat;

public class MainClass {
	public static void main(String[] args) {
		/*
		 AOP ( Aspect Oriented Programming )
		 		관점	  지향
		 		
		 공통 부분의 처리
		 Controller log 처리..
		 session 체크
		 DB 체크
		 
		 특정함수가 호출 되었을때 처리를 해줄수있다. (전 처리, 후 처리)
		 
		 */
		
		//Java에서 xml을 실행시
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("bean.xml");
		
		//XML에서 생성된 Object를 읽어들인다.
		Cat myCat = ctx.getBean("myCat", Cat.class);
		
		myCat.info();
		
		myCat.setAge(1);
		myCat.setColor("흰색");
		
	}
}

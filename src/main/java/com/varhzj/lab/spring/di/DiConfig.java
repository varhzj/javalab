package com.varhzj.lab.spring.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.varhzj.lab.spring.di")
public class DiConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);

		UseFunctionService useFucService = context.getBean(UseFunctionService.class);
		System.out.println(useFucService.sayHello("varhzj"));

		context.close();
	}

}

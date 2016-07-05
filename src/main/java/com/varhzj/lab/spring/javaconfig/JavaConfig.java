package com.varhzj.lab.spring.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public FunctionService functionService() {
		return new FunctionService();
	}

	@Bean
	public UseFunctionService useFunctionService() {
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(functionService());
		return useFunctionService;
	}

//	@Bean
//	public UseFunctionService useFunctionService(FunctionService functionService) {
//		UseFunctionService useFunctionService = new UseFunctionService();
//		useFunctionService.setFunctionService(functionService);
//		return useFunctionService;
//	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

		UseFunctionService ufs = context.getBean(UseFunctionService.class);
		System.out.println(ufs.sayHello("java config"));

		context.close();
	}
}

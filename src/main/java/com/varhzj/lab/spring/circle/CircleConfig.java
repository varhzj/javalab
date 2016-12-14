package com.varhzj.lab.spring.circle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by varhzj on 12/1/16.
 */
@Configuration
@ComponentScan
public class CircleConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CircleConfig.class);
        context.getBean(CircleA.class);
    }

}

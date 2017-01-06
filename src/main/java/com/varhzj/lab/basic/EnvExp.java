package com.varhzj.lab.basic;

/**
 * Created by varhzj on 1/5/17.
 */
public class EnvExp {

    public static void main(String[] args) {
        System.out.println("------------------------Envs--------------------------");
        System.getenv().forEach((key, value) -> System.out.println(key + " = " + value));
        System.out.println("----------------------Properties----------------------");
        System.getProperties().forEach((key, value) -> System.out.println(key + " = " + value));
        System.getProperties().list(System.out);
    }
}

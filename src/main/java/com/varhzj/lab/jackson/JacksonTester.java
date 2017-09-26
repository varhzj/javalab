package com.varhzj.lab.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by varhzj on 3/16/17.
 */
public class JacksonTester {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "{\"name\":\"Jack\", \"age\":21}";

//        mapper.

    }

}

class Student {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

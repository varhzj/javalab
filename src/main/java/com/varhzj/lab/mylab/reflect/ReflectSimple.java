package com.varhzj.lab.mylab.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by varhzj on 1/6/17.
 */
public class ReflectSimple {

    public static Person initByDefaultConstructor() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?> clazz = classLoader.loadClass("com.varhzj.lab.mylab.reflect.Person");
        Constructor<?> constructor = clazz.getConstructor((Class<?>[]) null);
        Person person = (Person) constructor.newInstance();

        Method setName = clazz.getMethod("setName", String.class);
        setName.invoke(person, "varhzj");
//        Method setAge = clazz.getMethod("setAge", Integer.class);
//        setAge.invoke(person, 26);
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true); // do not forget this, or will cause IllegalAccessException
        age.set(person, 26);
        Method setSex = clazz.getMethod("setSex", Person.Sex.class);
        setSex.invoke(person, Person.Sex.MALE);
        return person;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(initByDefaultConstructor());
    }

}

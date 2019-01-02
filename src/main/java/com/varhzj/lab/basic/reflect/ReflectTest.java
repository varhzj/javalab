package com.varhzj.lab.basic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Thread.currentThread()
                .getContextClassLoader()
                .loadClass("com.varhzj.lab.basic.reflect.Car");
        Constructor<?> defaultCons = aClass.getConstructor((Class<?>[]) null);
        Object defaultCar = defaultCons.newInstance();
        System.out.println(defaultCar.getClass());

        Field color = aClass.getDeclaredField("color");
        color.setAccessible(true);
        color.set(defaultCar, "red");

        Method print = aClass.getDeclaredMethod("print", (Class[]) null);
        print.setAccessible(true);
        print.invoke(defaultCar, (Object[]) null);
    }

}

package com.varhzj.lab.mylab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by varhzj on 12/1/16.
 */
public class GenericTest {

    public static void main(String[] args) {
        Test test = new Test();
        List<Integer> list = new ArrayList<>();
        test.methodStr(list);
        List<String> strList = new ArrayList<>();
        test.methodInt(strList);
    }

    public static class Test<T> {
        public void methodT(List<T> list) {
            System.out.println("t");
        }

        public void methodInt(List<Integer> list) {
            System.out.println("integer");

        }

        public void methodStr(List<String> list) {
            System.out.println("string");
        }
    }

}

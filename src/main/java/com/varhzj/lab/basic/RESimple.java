package com.varhzj.lab.basic;

import java.util.regex.Pattern;

/**
 * Created by varhzj on 1/5/17.
 */
public class RESimple {

    public static void main(String[] args) {
        String regex = "Q[^u]\\d+\\.";
        String[] input = {
                "QA777, QA456. It is on time.",
                "Quack, Quack, Qu123."
        };

        Pattern pattern = Pattern.compile(regex);
        for (String in : input) {
            boolean found = pattern.matcher(in).find();
            System.out.println("'" + regex + "'" + (found ? " matches '" : " not matches '") + in + "'");
        }
    }

}

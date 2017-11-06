package com.varhzj.lab.algorithms.base;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Average {

    public static void main(String[] args) {
        double sum = 0;
        int count = 0;
        while (!StdIn.isEmpty()) {
            sum += StdIn.readDouble();
            count++;
        }
        double avg = sum / count;
        StdOut.println("Average is " + avg);
    }

}

package com.varhzj.lab.tij.polymorphism.shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomShapeGenerator {

    private static Random random = new Random(94);

    public static Shape next() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[9];
        // 无效的赋值，注意
        for (Shape shape : shapes) {
            shape = next();
        }

        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = next();
        }

        for (Shape shape : shapes) {
            shape.draw();
        }

        String[] strArr = "Hello it is a test".split(" ");
        for (String str : strArr) {
            str = "1";
        }

        for (String str : strArr) {
            System.out.println(str);
        }
    }

    public <T extends Comparable<T>> List<T> merge(List<T> l1, List<T> l2) {

        List<T> res = new ArrayList<>(l1.size() + l2.size());
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i).compareTo(l2.get(j)) < 0) {
                res.add(l1.get(i++));
            } else {
                res.add(l2.get(j++));
            }
        }

        for (; i < l1.size(); i++) {
            res.add(l1.get(i));
        }
        for (; j < l2.size(); j++) {
            res.add(l2.get(j));
        }

        return res;
    }

}

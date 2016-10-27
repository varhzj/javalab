package com.varhzj.lab.java8.intro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by varhzj on 10/27/16.
 */
public class AppleFilter {

    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> res = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                res.add(apple);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(130, "green"));
        apples.add(new Apple(200, "green"));
        apples.add(new Apple(200, "red"));
        apples.add(new Apple(120, "red"));
        BiFunction<Integer, String, Apple> c = Apple::new;
        apples.add(c.apply(220, "green"));

        // 匿名类
        System.out.println("-----------Filter red apples-----------");
        List<Apple> redApples = filterApples(apples, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        for (Apple apple : redApples) {
            System.out.println(apple);
        }

        // 传递方法
        System.out.println("----------Filter green apples----------");
        List<Apple> greenApples = filterApples(apples, Apple::isGreenApple);
        greenApples.forEach(System.out::println);

        // lambda
        System.out.println("----------Filter heavy apples----------");
        List<Apple> heavyApples = filterApples(apples, (Apple a) -> a.getWeight() > 150);
        heavyApples.forEach((Apple a) -> System.out.println(a));

        // Stream方式
        System.out.println("-----Filter green and heavy apples-----");
        List<Apple> greenAndHeavyApples = apples.stream()
                .filter(apple -> apple.getWeight() > 150
                        && "green".equals(apple.getColor()))
                .collect(Collectors.toList());
        greenAndHeavyApples.forEach(System.out::println);

        // sort: 匿名类
        System.out.println("-----Sort apples -----");
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        apples.forEach(System.out::println);

        // sort: lambda
        System.out.println("-----Sort apples lambda -----");
        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        // apples.sort((a1, a2) -> a2.getWeight().compareTo(a1.getWeight())); 与上一行作用相同
        apples.forEach(System.out::println);
    }

}

class Apple {

    private Integer weight;
    private String color;

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

}

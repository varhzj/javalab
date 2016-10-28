package com.varhzj.lab.java8.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by varhzj on 10/27/16.
 */
public class StreamSample {

    private static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 500, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args) {

        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        // 流只能消费一次
        // s.forEach(System.out::println);

        top3HighCaloricDishNames();

        allDishNames();

        first3HighCaloricDishNamse();

        countHighCaloricDish();

        vegetarianDishes();

        distinctEvenNumbers();

        skip2HighCaloricDishes();

        uniqueCharacters();

        allNumberPairs();

        matchAndFind();

        reduceSamples();

        sumCalories();

        rangeSamples();

        createStream();
    }

    private static void createStream() {
        // 由值创建
        Stream<String> stringStream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stringStream.map(String::toUpperCase)
                .forEach(System.out::println);

        // 由数组创建
        int[] numbers = {1, 3, 5, 7, 35, 23};
        System.out.println("sum of numbers: " + Arrays.stream(numbers).sum());

        // 由文件创建
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get(System.getProperty("user.dir"), "README.md"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println("uniqueWords in README.md: " + uniqueWords);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 由函数生成: 创建无限流
        // iterate
        System.out.println("using iterate to generate stream:");
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("using iterate to generate fib tuple:");
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        System.out.println("using iterate to generate fib:");
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(15)
                .map(t -> t[0])
                .forEach(System.out::println);

        // generate
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    private static void rangeSamples() {
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        // take care IntStream.range(start, end) which not contains the start and end
        System.out.println("evenNumbers count from 1 to 100 enclosed:" + evenNumbers.count());

        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );
        pythagoreanTriples.limit(3)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2])
                );

        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0)
                );
    }

    private static void sumCalories() {
        int sum = menu.stream()
                // 原始类型流特化: IntStream, DoubleStream, LongStream
                .mapToInt(Dish::getCalories)
                .sum();
        Stream<Integer> boxed = menu.stream()
                .mapToInt(Dish::getCalories)
                //  使用boxed转换回对象流
                .boxed();

        System.out.println("sumCalories: " + sum);
    }

    private static void reduceSamples() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 8, 6, 7, 5);

        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("sum: " + sum);

        // using parallelStream
        sum = numbers.parallelStream()
                .reduce(0, Integer::sum);
        System.out.println("sum: " + sum);

        Optional<Integer> maxOptional = numbers.stream()
                .reduce(Integer::max);
        maxOptional.ifPresent(max -> System.out.println("maxOptional: " + max));

        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
//        int max = maxCalories.orElse(-1);
        System.out.println("maxCalories: " + maxCalories.orElse(-1));

        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("product: " + product);

        long count = numbers.stream().count();
        System.out.println("number counts: " + count);
    }

    private static void matchAndFind() {
        // 短路模式
        System.out.println("anyVegetarian: " + menu.stream()
                .anyMatch(Dish::isVegetarian)
        );

        System.out.println("isHealthy: " + menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000)
        );

        System.out.println("isHealthy the other way: " + menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000)
        );

        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println("vegetarian: " + dish.getName()));

        menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.FISH)
                .findFirst()
                .ifPresent(dish -> System.out.println("first fish dish: " + dish.getName()));
    }

    private static void allNumberPairs() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> numbers2 = Arrays.asList(3, 4, 5);
        numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .forEach(pair -> System.out.println("{" + pair[0] + ", " + pair[1] + "}"));
    }

    private static void uniqueCharacters() {
        List<String> words = Arrays.asList("Hello", "World", "And", "Goodbye");
        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }

    private static void skip2HighCaloricDishes() {
        List<Dish> dishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                // using skip
                // if skips more than stream's size, it will return empty stream
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("skip2HighCaloricDishes: " + dishes);
    }

    private static void distinctEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 2, 3, 5, 6, 2, 1);
        System.out.println("distinctEvenNumbers: ");
        numbers.stream()
                .filter(i -> i % 2 == 0)
                // use distinct
                .distinct()
                .forEach(System.out::println);
    }

    private static void vegetarianDishes() {
        List<Dish> vegetarianDishes = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println("vegetarianDishes: " + vegetarianDishes);
    }

    private static void countHighCaloricDish() {
        long count = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .distinct()
                .count();
        System.out.println("countHighCaloricDish: " + count);
    }

    private static void top3HighCaloricDishNames() {
        List<String> top3HighCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("top3HighCaloricDishNames: " + top3HighCaloricDishNames);
    }

    private static void allDishNames() {
        List<String> allDishNames = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("dishNames: " + allDishNames);
    }

    private static void first3HighCaloricDishNamse() {
        List<String> first3HighCaloricDishNames = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("first3HighCaloricDishNames: " + first3HighCaloricDishNames);
    }


}

package com.company.junseok.one;

import com.company.junseok.one.formatter.AppleFancyFormatter;
import com.company.junseok.one.formatter.AppleFormatter;
import com.company.junseok.one.formatter.AppleSimpleFormatter;
import com.company.junseok.one.predicate.ApplePredicate;
import com.company.junseok.one.predicate.AppleRedAndHeavyPredicate;
import com.company.junseok.one.predicate.Predicate;
import com.company.junseok.one.print.AppleHeavyAndLightPrint;
import com.company.junseok.one.print.ApplePrint;
import com.company.junseok.one.print.AppleWeightPrint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(Color.GREEN, 150));
        inventory.add(new Apple(Color.RED, 200));
        inventory.add(new Apple(Color.GREEN, 80));

        List<Apple> apples = Sample.filterGreenApples(inventory);
        apples.forEach((Apple apple) -> { apple.getColor(); });

        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
        List<Apple> redAndHeavyApples = filterApples2(inventory, new AppleRedAndHeavyPredicate());

        prettyPrintApple(inventory, new AppleWeightPrint());
        prettyPrintApple(inventory, new AppleHeavyAndLightPrint());

        prettyPrintApple2(inventory, new AppleSimpleFormatter());
        prettyPrintApple2(inventory, new AppleFancyFormatter());

        List<Apple> redApples = filterApples2(inventory, new ApplePredicate() {

            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });

        List<Apple> redApples2 = filterApples2(inventory, apple -> Color.RED.equals(apple.getColor()));

        Stream<Integer> integerStream = Stream.iterate(30, n -> n + 2).limit(5);

        List<Integer> integers = integerStream.collect(Collectors.toList());

        List<Integer> evenNumbers = filter(integers, i -> i % 2 == 0);

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        });
        t.run();

        Thread t2 = new Thread(() -> System.out.println("Hello world"));
        t2.run();

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });
        System.out.println(threadName);

        Future<String> threadName2 = executorService.submit(() -> Thread.currentThread().getName());
        System.out.println(threadName2);

    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples2(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, ApplePrint p) {
        for (Apple apple: inventory) {
            String print = p.execute(apple);
            System.out.println(print);
        }
    }

    public static void prettyPrintApple2(List<Apple> inventory, AppleFormatter formatter) {

        for (Apple apple: inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e: list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}

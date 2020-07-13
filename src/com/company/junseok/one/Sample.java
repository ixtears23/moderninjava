package com.company.junseok.one;

import java.util.ArrayList;
import java.util.List;

enum Color { RED, GREEN }

public class Sample {
    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(Color.GREEN, 150));
        inventory.add(new Apple(Color.RED, 200));
        inventory.add(new Apple(Color.GREEN, 80));

        List<Apple> apples = Sample.filterGreenApples(inventory);
        apples.forEach((Apple apple) -> { apple.getColor(); });

        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
        List<Apple> redAndHeavyApples = filterApples2(inventory, new AppleRedAndHeavyPredicate());

        prettyPrintApple(inventory, new AppleWeightPrint());
        prettyPrintApple(inventory, new AppleHeavyAndLightPrint());
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
}

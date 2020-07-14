package com.company.junseok.one.formatter;

import com.company.junseok.one.Apple;

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        String prettyPrint = "A " + characteristic + " " + apple.getColor() + " apple";
        return prettyPrint;
    }
}

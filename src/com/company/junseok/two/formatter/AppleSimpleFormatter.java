package com.company.junseok.two.formatter;

import com.company.junseok.two.Apple;

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return String.format("An apple of %sg", apple.getWeight());
    }
}

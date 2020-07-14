package com.company.junseok.one.formatter;

import com.company.junseok.one.Apple;

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return String.format("An apple of %sg", apple.getWeight());
    }
}

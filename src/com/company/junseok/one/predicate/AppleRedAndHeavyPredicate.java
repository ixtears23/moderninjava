package com.company.junseok.one.predicate;

import com.company.junseok.one.Apple;
import com.company.junseok.one.Color;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor()) && apple.getWeight() > 150;
    }
}

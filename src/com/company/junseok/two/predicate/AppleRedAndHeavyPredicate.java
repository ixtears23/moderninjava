package com.company.junseok.two.predicate;

import com.company.junseok.two.Apple;
import com.company.junseok.two.Color;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor()) && apple.getWeight() > 150;
    }
}

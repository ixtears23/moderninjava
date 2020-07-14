package com.company.junseok.two.predicate;

import com.company.junseok.two.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

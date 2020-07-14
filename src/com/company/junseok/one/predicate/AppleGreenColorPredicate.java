package com.company.junseok.one.predicate;

import com.company.junseok.one.Apple;
import com.company.junseok.one.Color;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}

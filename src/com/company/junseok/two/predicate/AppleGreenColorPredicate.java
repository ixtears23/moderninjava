package com.company.junseok.two.predicate;

import com.company.junseok.two.Apple;
import com.company.junseok.two.Color;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}

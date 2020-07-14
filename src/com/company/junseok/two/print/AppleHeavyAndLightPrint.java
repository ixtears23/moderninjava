package com.company.junseok.two.print;

import com.company.junseok.two.Apple;

public class AppleHeavyAndLightPrint implements ApplePrint {
    @Override
    public String execute(Apple apple) {
        return apple.getWeight() < 150 ? "가벼운 사과" : "무거운사과";
    }
}

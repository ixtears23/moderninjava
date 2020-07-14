package com.company.junseok.one.print;

import com.company.junseok.one.Apple;

public class AppleWeightPrint implements ApplePrint {
    @Override
    public String execute(Apple apple) {
        return String.format("사과의 무게는 %s", apple.getWeight());
    }
}

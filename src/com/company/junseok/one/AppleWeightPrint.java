package com.company.junseok.one;

import java.util.List;

public class AppleWeightPrint implements ApplePrint {
    @Override
    public String execute(Apple apple) {
        return String.format("사과의 무게는 %s", apple.getWeight());
    }
}

package com.company.junseok.practice.lambda;

public class Sonata implements CarNamePrint {

    private static final String carName = "sonata";

    @Override
    public void print() {
        System.out.println(carName);
    }
}

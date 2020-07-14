package com.company.junseok.practice.lambda;

@FunctionalInterface
public interface CarNamePrint {

    void print();

    default String name() {
        return "good";
    }
}

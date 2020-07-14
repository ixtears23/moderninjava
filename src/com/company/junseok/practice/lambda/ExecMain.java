package com.company.junseok.practice.lambda;

public class ExecMain {
    public static void main(String[] args) {


        prettyPrint(new CarNamePrint() {
            @Override
            public void print() {
                System.out.println("임의차");
            }
        });

        prettyPrint(new Sonata());

        prettyPrint(() -> System.out.println("Sorento"));
    }


    private static void prettyPrint(CarNamePrint cnp) {
        cnp.print();
    }
}

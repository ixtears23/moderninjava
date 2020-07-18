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

        Runnable r =  () -> System.out.println("Hello World 1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };

        process(r);
        process(r2);
        process(() -> System.out.println("Hello world 3"));
    }

    public static void process(Runnable r) {
        r.run();
    }


    private static void prettyPrint(CarNamePrint cnp) {
        cnp.print();
    }
}

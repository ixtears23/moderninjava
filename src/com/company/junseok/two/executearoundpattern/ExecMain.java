package com.company.junseok.two.executearoundpattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecMain {
    public static void main(String[] args) {
        try {
            String oneLine = processFile((BufferedReader br ) -> br.readLine());
            String twoLine = processFile((BufferedReader br ) -> br.readLine() + br.readLine());

            System.out.println(oneLine);
            System.out.println(twoLine);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
}

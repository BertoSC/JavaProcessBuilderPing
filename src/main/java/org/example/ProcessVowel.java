package org.example;

import java.io.*;

public class ProcessVowel {

    public static void main(String[] args) throws FileNotFoundException {
        char[] v = new char[]{'a', 'e', 'i', 'o', 'u'};
        int suma = 0;
        String temp;
        for (char c : v) {
            String command = "java -cp target\\classes org.example.ProcessBuilderVowels " + String.valueOf(c);
            ProcessBuilder pb = new ProcessBuilder(command.split("\\s"));
            pb.inheritIO();

            try {
                pb.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        for (char c : v) {
            try (var in = new BufferedReader(new FileReader(c + "_archivo.txt"))) {
                while ((temp = in.readLine()) != null) {
                    System.out.println("El número de :"+c+" es : " +temp);
                    suma+=Integer.parseInt(temp);
                }
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
        System.out.println(suma);

    }
}
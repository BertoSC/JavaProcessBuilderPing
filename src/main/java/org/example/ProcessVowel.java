package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ProcessVowel {

    public static void main(String[] args) throws FileNotFoundException {
        char[] v = new char[]{'a', 'e', 'i', 'o', 'u'};
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
    }
}
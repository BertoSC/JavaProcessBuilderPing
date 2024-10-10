package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class ProcessBuilderTracert {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] comando = {"CMD", "/C", "tracert", "www.iessanclemente.net"};
        ProcessBuilder pb = new ProcessBuilder(comando);

        File arch = new File("prueba.txt");
        Path p = Files.createFile(arch.toPath());
        pb.redirectOutput(p.toFile());
        Process otro = pb.start();

        if (!otro.waitFor(500, TimeUnit.MILLISECONDS)) {
            otro.destroy();
            throw new InterruptedException();

        }
    }
}
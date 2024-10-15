package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProcessBuilderVowels {
    public static void vowelCounter(char v){
        int counter=0;
        v=Character.toLowerCase(v);
        StringBuilder contenido= new StringBuilder();
        String temp;
        try(var br = new BufferedReader(new FileReader("fileData.txt"))){
            while((temp = br.readLine())!= null) {
                contenido.append(temp);
            }
        } catch (IOException e){
            System.out.println("Error de lectura");
        }
        String definitivo = contenido.toString().toLowerCase();
        char vocal;
        for (char c : definitivo.toCharArray()){
            if (c==v){
                counter++;
            }
        }

        String resultado=Integer.toString(counter);

        try (var out = new BufferedWriter(new FileWriter(v+"_archivo.txt"))){
            out.write(resultado);
        } catch (IOException e){
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        char vocal = args[0].charAt(0);
        vowelCounter(vocal);
    }


}

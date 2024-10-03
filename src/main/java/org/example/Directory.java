package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Directory {
    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        System.out.println("INCRESE UNA RUTA VÁLIDA:");
        String path = sc.nextLine();
        // usar directory() */
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "dir");

        //para la segunda parte establecemos que ejecute el dir en C
        //pb.directory(new File ("C:")//

        System.out.println(pb.directory());  // improme el directorio de trabajo en el que está



       // PARTE TRES
       //EJECUTAR UN DIR MEDIANTE COMANDO
        pb.directory(new File(path));//establecemos el directorio donde se ejecutará el procespo

        pb.inheritIO();
        pb.start();






    }
}

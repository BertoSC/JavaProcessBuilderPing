package org.example;
import java.io.IOException;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        String[] comando = {"CMD", "/C", "echo %saludo%"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        Map<String, String> entorno= pb.environment();

        entorno.put("saludo", "Hello World");
        System.out.println("Entorno de ejecución del proceso:");

        //CON ENTRYSET()
        /*for (Map.Entry<String, String> entry : entorno.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/

        //CON EL MÉTODO FOR EACH de PROGRAMACIÓN FUNCIONAL
        entorno.forEach((clave,valor)->System.out.println(clave+ " "+valor) );
        pb.inheritIO();
        pb.start();
    }
}

package org.example;

/*
set /A num1=6
set /A num2=4
set /A suma=num1+num2
echo la suma es %suma%
la suma es 10
*/

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


public class Enviroment {
    public static void main(String[] args) {


        // El comando ahora tiene dos partes: primero calculamos la suma, luego mostramos la variable
        String[] comando = {"CMD", "/C", "echo El resultado de sumar %num1% y %num2% es:","&&", "set", "/A", "suma=num1+num2"};

        // Construimos el proceso
        ProcessBuilder pb = new ProcessBuilder(comando);

        // Configuramos las variables de entorno
        Map<String, String> entorno = pb.environment();
        entorno.put("num1", "6");
        entorno.put("num2", "4");
        pb.inheritIO();


        try {

            Process p = pb.start();
            int codRet = p.waitFor();
            System.out.println("The execution of " + Arrays.toString(args)
                    + " returns " + codRet
                    + " " + (codRet == 0 ? "(OK)" : "(ERROR)")
            );
        } catch (IOException e) {
            System.err.println("Error during the execution of the process");
            System.err.println("Detailed information");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("---------------------");
            System.exit(2);
        } catch (InterruptedException e) {
            System.err.println("Interrupted process");
            System.exit(3);
        }
    }
}

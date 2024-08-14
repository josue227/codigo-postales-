package mx.unison;

/* Contar cuantos códigos postales corresponden a asentamientos rurales
y cantos a asentamientos rurales
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String archivo = "codigos_postales.csv";
        String linea;
        String separador = ",";
        int contadorUrbano = 0;
        int contadorRural = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(separador);


                if (partes.length >= 3) {
                    String tipoAsentamiento = partes[2].trim();

                    // Contar el tipo de asentamiento
                    if (tipoAsentamiento.equalsIgnoreCase("Urbano")) {
                        contadorUrbano++;
                    } else if (tipoAsentamiento.equalsIgnoreCase("Rural")) {
                        contadorRural++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir resultados
        System.out.println("Número de asentamientos urbanos: " + contadorUrbano);
        System.out.println("Número de asentamientos rurales: " + contadorRural);
    }
}

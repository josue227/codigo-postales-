package mx.unison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EncontrarCodigo {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Uso: java EncontrarCodigo <codigo_postal_1> <codigo_postal_2> ... <codigo_postal_n>");
            return;
        }

        String archivo = "codigos_postales.csv";
        String linea;
        String separador = ",";


        Map<String, String[]> codigoPostalMap = new HashMap<>();

        // Leer el archivo y almacenar la información en el mapa
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(separador);

                if (partes.length >= 3) {
                    String codigoPostal = partes[0].trim();
                    String colonia = partes[1].trim();
                    String tipoAsentamiento = partes[2].trim();


                    codigoPostalMap.put(codigoPostal, new String[]{colonia, tipoAsentamiento});
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Buscar y mostrar la información para cada código postal proporcionado como argumento
        for (String codigoPostalInput : args) {
            codigoPostalInput = codigoPostalInput.trim();
            if (codigoPostalMap.containsKey(codigoPostalInput)) {
                String[] info = codigoPostalMap.get(codigoPostalInput);
                String colonia = info[0];
                String tipoAsentamiento = info[1];

                // Mostrar la información
                System.out.println("Código Postal: " + codigoPostalInput);
                System.out.println("Colonia: " + colonia);
                System.out.println("Tipo de Zona: " + tipoAsentamiento);
                System.out.println();  // Línea en blanco para separación
            } else {
                System.out.println("Código Postal " + codigoPostalInput + " no se encuentra en el archivo.");
            }
        }
    }
}

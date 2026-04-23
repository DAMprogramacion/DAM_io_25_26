package ejercicios.ejercicio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Path inPath  = Paths.get("ficheros/ciudades.csv");
        Path outPath = Paths.get("ficheros/ciudadesAnalisis.txt");
        Set<Ciudad> ciudades = new HashSet<>();
        //lectura del fichero csv
        try {
            List<String> lineas = Files.readAllLines(inPath);
            for (String linea : lineas) {
                String[] tokens = linea.split(",");
                try {
                    double longitud = Double.parseDouble(tokens[2]);
                    double latitud = Double.parseDouble(tokens[3]);
                    ciudades.add(new Ciudad(tokens[0], tokens[1], longitud, latitud ));
                } catch (NumberFormatException e) {
                    System.err.println(e);                }
            }
        } catch (IOException e) {
            System.err.println(e);;
        }
        System.out.printf("Leídas %d ciudades%n", ciudades.size());
        String datos = obtenerDatos(ciudades);
        System.out.println(datos);
        try {
            Files.writeString(outPath, datos);
            System.out.printf("Escritos %d bytes en el fichero %s%n", Files.size(outPath), outPath);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static String obtenerDatos(Set<Ciudad> ciudades) {
        long nCiudadesNorte = ciudades.stream().
                                filter(ciudad -> ciudad.getLatitud() > 0).
                                count();
        long nCiudadesEste = ciudades.stream().
                filter(ciudad -> ciudad.getLongitud() > 0).
                count();
        long nCiudadesSpain = ciudades.stream().
                filter(ciudad -> ciudad.getNombrePais().equalsIgnoreCase("spain")).
                count();
        long nCiudadesChina = ciudades.stream().
                filter(ciudad -> ciudad.getNombrePais().equalsIgnoreCase("china")).
                count();
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("Nº de ciudades del norte: ").append(nCiudadesNorte).append('\n');
        int size = ciudades.size();
        sBuilder.append("Nº de ciudades del sur: ").
                append(
                        size - nCiudadesNorte).append('\n');
        sBuilder.append("Nº de ciudades del este: ").append(nCiudadesEste).append('\n');
        sBuilder.append("Nº de ciudades del oeste: ").
                append(size - nCiudadesEste).append('\n');
        sBuilder.append("Nº de ciudades de españa: ").append(nCiudadesSpain).append('\n');
        sBuilder.append("Nº de ciudades de china: ").append(nCiudadesChina);

        return sBuilder.toString();
    }
}

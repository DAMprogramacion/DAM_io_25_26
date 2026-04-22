package teoria.escrituraLecturaFicherosTexto.lecturaLineas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        Path inPath = Paths.get("ficheros/personas.csv");
        try {
            List<String> lineas = Files.readAllLines(inPath);
            for (String linea : lineas) {
                String[] tokens = linea.split(",");
                String nombrePersona = tokens[0].trim();
                String sEdadPersona = tokens[1].trim();
                try {
                    int iEdadPersona    = Integer.parseInt(sEdadPersona);
                    Persona persona = new Persona(nombrePersona, iEdadPersona);
                    personas.add(persona);
                } catch (NumberFormatException e) {
                    System.err.println(e);
                }
            }
        } catch (IOException  e) {
            System.err.println(e);;
        }
        personas.forEach(System.out::println);
        System.out.println("Fin de programa");
    }
}

package teoria.escrituraLecturaFicherosTexto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EjemploBasicoTres {
    public static void main(String[] args) {
        Path inPath = Paths.get("ficheros/quijote.txt");
        try {
            String contenido  = Files.readString(inPath);
            System.out.printf("Tamaño del fichero leído: %d bytes%n", Files.size(inPath));
            System.out.printf("Caracteres leídos: %d%n", contenido.length());
            //quiero saber cuantas veces aparece la palabra Quijote en el texto
            String[] tokens = contenido.split("[\s\n]");
            //System.out.println(Arrays.toString(tokens)); comprobaciĺn
            int contadorQuijotes = 0;
            for (String palabra : tokens) {
                if (palabra.toLowerCase().contains("quijote")) {
                    System.out.println(palabra);
                    contadorQuijotes++;
                }
            }
            System.out.printf("Nº veces palabra quijote %d%n", contadorQuijotes);
        } catch (IOException e) {
            System.err.println(e);;
        }
        System.out.println("Fin de programa");
    }
}

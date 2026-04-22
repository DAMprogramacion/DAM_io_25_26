//escribiendo texto en un fichero usando Files.writeString
package teoria.escrituraLecturaFicherosTexto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EjemploBasicoUno {
    public static void main(String[] args) {
        Path outPath = Paths.get("ficheros/ficheroUno.txt");
        String texto = "Texto a escribir en fichero y una ñ\n";
        try {
            Files.writeString(outPath, texto);
            Files.writeString(outPath, texto); //sobreescribe el fichero
            Files.writeString(outPath, "nueva línea", StandardOpenOption.APPEND);
            System.out.printf("Escritos %d bytes en %s%n", Files.size(outPath), outPath);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

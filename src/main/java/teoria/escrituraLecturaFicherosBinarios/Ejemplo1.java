package teoria.escrituraLecturaFicherosBinarios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//leemos una imagen
public class Ejemplo1 {
    public static void main(String[] args) {
        Path inPath = Paths.get("ficheros/java.webp");
        byte[] bytesImagen = null;
        try {
            bytesImagen = Files.readAllBytes(inPath);
            System.out.printf("Leidos %d bytes%n", bytesImagen.length);
        } catch (IOException e) {
            System.err.println(e);
        }
        if (bytesImagen != null)
            for (byte byteLeido : bytesImagen)
                System.out.printf("Byte leido %d%n ", byteLeido);
    }
}

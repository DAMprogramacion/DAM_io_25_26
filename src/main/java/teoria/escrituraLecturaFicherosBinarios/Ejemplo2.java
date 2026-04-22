package teoria.escrituraLecturaFicherosBinarios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ejemplo2 {
    public static void main(String[] args) {
        Path outPath = Paths.get("ficheros/salidaBinaria");
        byte[] bytes = new byte[10];
        int contador = 100;
        for (int i = 0; i < 10 ; i++) {
            bytes[i] = (byte) contador++;
        }
        System.out.println(Arrays.toString(bytes));
        try {
            Files.write(outPath, bytes);
        } catch (IOException e) {
            System.err.println();;
        }

    }
}

package teoria.escrituraLecturaFicherosTexto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

//calcular el valor medio de los datos del fichero numbers.txt
public class EjercicoBasicoCuatro {
    public static void main(String[] args) {
        double valorMedio = 0;
        Path inPath = Paths.get("ficheros/numbers.txt");
        try (Stream<String> stream = Files.lines(inPath)) {
              valorMedio = stream.
                    mapToDouble(Double::parseDouble).
                    average().
                    orElse(0);

            System.out.printf("Valor medio %.2f%n", valorMedio);


        } catch (IOException e) {
            System.err.println(e);
        }
        try (Stream<String> stream = Files.lines(inPath)) {
            double sumaValores = stream.
                    mapToDouble(Double::parseDouble).
                    sum();
            System.out.printf("Suma valores %.2f%n", sumaValores);
        } catch (IOException e) {
            System.err.println(e);
        }
        try (Stream<String> stream = Files.lines(inPath)) {
            double finalValorMedio = valorMedio;
            long valoresPorDebajoMedia = stream.
                    mapToDouble(Double::parseDouble).
                    filter(numero -> numero < finalValorMedio).
                    count();
            System.out.printf("Valores por debajo de la media %d%n", valoresPorDebajoMedia);
        } catch (IOException e) {
            System.err.println(e);
        }

        System.out.println("Fin de programa");
    }
}

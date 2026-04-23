package ejercicios.ejercicio1;

import java.util.Objects;

public class Ciudad {
    private final String nombreCiudad;
    private final String nombrePais;
    private final double longitud;
    private final double latitud;

    public Ciudad(String nombreCiudad, String nombrePais, double longitud, double latitud) {
        this.nombreCiudad = nombreCiudad;
        this.nombrePais = nombrePais;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ciudad ciudad = (Ciudad) o;
        return Objects.equals(nombreCiudad.toLowerCase(), ciudad.nombreCiudad.toLowerCase())
                && Objects.equals(nombrePais.toLowerCase(), ciudad.nombrePais.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreCiudad, nombrePais);
    }

    @Override
    public String toString() {
        StringBuilder sBuilider = new StringBuilder();
        sBuilider.append("ciudad: ").append(nombreCiudad).append('\n');
        sBuilider.append("país: ").append(nombrePais).append('\n');
        sBuilider.append("latitud: ").append(String.format("%.2f", latitud)).append('\n');
        sBuilider.append("longitud: ").append(String.format("%.2f", longitud)).append('\n');
        return sBuilider.toString();
    }






}

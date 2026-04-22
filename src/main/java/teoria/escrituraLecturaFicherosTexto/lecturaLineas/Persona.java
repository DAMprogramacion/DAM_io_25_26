package teoria.escrituraLecturaFicherosTexto.lecturaLineas;

public class Persona {
    private String nombrePersona;
    private int edadPersona;

    public Persona(String nombrePersona, int edadPersona) {
        this.nombrePersona = nombrePersona;
        this.edadPersona = edadPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public int getEdadPersona() {
        return edadPersona;
    }

    public void setEdadPersona(int edadPersona) {
        this.edadPersona = edadPersona;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("nombre: ").append(nombrePersona).append('\n');
        sBuilder.append("edad: ").append(edadPersona).append('\n');
        return sBuilder.toString();
    }
}

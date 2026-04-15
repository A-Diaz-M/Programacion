package b800varios.E855PriorityQueueTriageDelHospital;

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private Gravedad gravedad;

    public Paciente(String nombre, String sintoma, Gravedad gravedad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.gravedad = gravedad;
    }

    public String toString() {
        return "Paciente: " + getNombre() + " / Síntoma: " + getSintoma() + " / Nivel: " + getGravedad();
    }

    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public Gravedad getGravedad() {
        return gravedad;
    }

    public int compareTo(Paciente otro) {
        return this.gravedad.ordinal() - otro.gravedad.ordinal();
    }
}
package b800varios.E861ExcepcionesEnReloj;

// Se lanza cuando una operación llevaría el reloj fuera del rango [00:00, 23:59].
public class DesbordamientoRelojException extends Exception {
    private static final long serialVersionUID = 1L;

    private boolean superior;

    public boolean isSuperior() {
        return superior;
    }

    public void setSuperior(boolean superior) {
        this.superior = superior;
    }

    public DesbordamientoRelojException(String message, boolean superior) {
        super(message);
        this.superior = superior;
    }
}
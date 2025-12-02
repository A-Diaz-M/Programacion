void main() {
    double[] calificaciones = {5.7, 9.5, 4.9, 0.0, 7.75};
    double[] pesos = {0.15, 0.20, 0.25, 0.30, 0.10};
    double mediaPonderada = 0;
    boolean aprobado = true;

    for (int i = 0; i < calificaciones.length; i++) {
        mediaPonderada += calificaciones[i] * pesos[i];
        if (calificaciones[i] < 4) {
            aprobado = false;
        }
    }

    if (aprobado) {
        IO.println(String.format("El alumno ha aprobado con %.2f", mediaPonderada));

    } else if (mediaPonderada >= 5 && aprobado == false) {
        IO.println(String.format("El alumno ha suspendido con %.2f ya que no tiene todo con mas de 4.0", mediaPonderada));

    } else if (mediaPonderada < 5 && aprobado) {
        IO.println(String.format("El alumno ha suspendido con %.2f ya que no llega al 5", mediaPonderada));

    } else if (mediaPonderada < 5 && aprobado == false) {
        IO.println(String.format("El alumno ha suspendido con %.2f ya que no tiene todo con mas de 4.0 y no llega al 5.0 de media", mediaPonderada));
    }
}
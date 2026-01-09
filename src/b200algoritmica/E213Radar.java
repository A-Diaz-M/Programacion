import java.util.Scanner;

void main() {
    String entradaSimulada = """
    30
    4
    10 200
    15 350
    17 420
    29 730
    25
    5
    10 100
    14 160
    19 205
    24 290
    26 315
    0
    """;

    Scanner entradaSim = new Scanner(entradaSimulada);

    while (true) {

        int limite = entradaSim.nextInt();

        if (limite == 0) {
            break;
        }

        int numPuntos = entradaSim.nextInt();

        int tiempoAnterior = 0;
        int posicionAnterior = 0;
        int excesos = 0;

        for (int i = 0; i < numPuntos; i++) {

            int tiempo = entradaSim.nextInt();
            int posicion = entradaSim.nextInt();

            if (i > 0) {
                int deltaTiempo = tiempo - tiempoAnterior;
                int deltaPosicion = posicion - posicionAnterior;

                double velocidad = (double) deltaPosicion / deltaTiempo;

                if (velocidad > limite) {
                    excesos++;
                }
            }

            tiempoAnterior = tiempo;
            posicionAnterior = posicion;
        }

        if (excesos == 0) {
            IO.println("TODO BIEN");
        } else if (excesos == 1) {
            IO.println("AVISO");
        } else {
            IO.println("MULTA");
        }
    }
}
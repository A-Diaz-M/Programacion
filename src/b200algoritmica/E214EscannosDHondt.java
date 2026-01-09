void main() {
    int[] votos = {1463183, 1004599, 557780, 506164, 21742, 7652, 6749, 3784, 3407, 2902, 1751};
    int[] divisores = new int[votos.length];
    int[] escannos = new int[votos.length];

    int numEscannos = 37;
    int numPartidos = votos.length;
    int totalGeneralDeVotos = 0;

    for (int voto : votos) {
        totalGeneralDeVotos += voto;
    }

    for (int i = 0; i < divisores.length; i++) {
        divisores[i] = 1;
    } //Arrays.fill(divisores, 1);

    for (int i = 0; i < numEscannos; i++) {
        double max = 0;
        int indicePartidoProxEscanno = 0;

        for (int j = 0; j < numPartidos; j++) {

            double valor = (double) votos[j] / divisores[j];

            if (valor > max) {
                max = valor;
                indicePartidoProxEscanno = j;
            }
        }
        escannos[indicePartidoProxEscanno]++;
        divisores[indicePartidoProxEscanno]++;
    }

    for (int i = 0; i < escannos.length; i++) {
        IO.println(String.format("Partido %d: %d escaños.", (i + 1), escannos[i]));
    }
    IO.println("Los votos totales son: "+totalGeneralDeVotos);
}
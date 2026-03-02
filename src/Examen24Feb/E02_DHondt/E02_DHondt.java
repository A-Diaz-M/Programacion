void main() {
    int[] votos = {1463183, 1004599, 557780, 506164, 21742, 7652, 6749, 3784, 3407, 2902, 1751};
    int[] escannos = new int[votos.length];
    int numEscannos = 37;
    int totalVotos = 0;

    for (int numPartido = 0; numPartido < votos.length; numPartido++) {
        totalVotos = totalVotos + votos[numPartido];
    }

    for (int numEscanno = 1; numEscanno <= numEscannos; numEscanno++) {
        double pujaMax = -1;
        int partidoProximoEscanno = -1;

        for (int numPartido = 0; numPartido < votos.length; numPartido++) {
            double puja = (double) votos[numPartido] / (escannos[numPartido] + 1);

            if (puja > pujaMax) {
                pujaMax = puja;
                partidoProximoEscanno = numPartido;
            }
        }
        escannos[partidoProximoEscanno]++;

        IO.println(String.format("Escaño para el partido %2d.", partidoProximoEscanno + 1));
    }

    IO.println();
    for (int partido = 0; partido < votos.length; partido++) {
        IO.println(String.format(
                "Partido %2d: %,9d votos (%5.2f%%) --> %2d escaños (proporcionalmente serían %5.2f escaños).",
                partido + 1,
                votos[partido],
                100.00 * votos[partido] / totalVotos,
                escannos[partido],
                1.00 * numEscannos * votos[partido] / totalVotos
        ));
    }
}
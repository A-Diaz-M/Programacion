void dibujarCuadradoHueco(int lado) {
    for (int fila = 1; fila <= lado; fila++) {
        for (int columna = 1; columna <= lado; columna++) {
            boolean enElBorde = (fila == 1 || fila == lado || columna == 1 || columna == lado);
            IO.print(enElBorde ? " * " : "   ");
        }
        IO.println();
    }
}

void dibujarRectanguloHueco(int anchura, int altura) {
    for (int fila = 1; fila <= altura; fila++) {
        for (int columna = 1; columna <= anchura; columna++) {
            boolean enElBorde = fila == 1 || fila == altura || columna == 1 || columna == anchura;
            IO.print(enElBorde ? "*" : " ");
        }
        IO.println();
    }
}

void dibujarPiramideSolida(int altura) {
    for (int fila = 0; fila < altura; fila++) {
        for (int espacio = 0; espacio < altura - fila - 1; espacio++) {
            IO.print(" ");
        }
        for (int asterisco = 0; asterisco < 2 * fila + 1; asterisco++) {
            IO.print("*");
        }
        IO.println();
    }
}

void dibujarTrianguloRectanguloHueco(int altura, int base) {
    double pendiente = (double) (base - 1) / altura;
    double desplazamientoHorizontal = 1;
    for (int fila = 1; fila <= altura; fila++) {
        int desplazamientoHorizontalRedondeado = (int) Math.round(desplazamientoHorizontal);

        for (int columna = 1; columna <= desplazamientoHorizontalRedondeado; columna++) {
            boolean enElBorde = (fila == 1 || fila == altura || columna == 1 || columna == desplazamientoHorizontalRedondeado);
            IO.print(enElBorde ? "*" : " ");
        }
        IO.println();

        desplazamientoHorizontal = desplazamientoHorizontal + pendiente;
    }
}

void main() {
    dibujarRectanguloHueco(4, 8);
    IO.println();

    dibujarPiramideSolida(5);
    IO.println();

    dibujarTrianguloRectanguloHueco(5, 13);
}

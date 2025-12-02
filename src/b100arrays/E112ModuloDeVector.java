void main() {
    double[] vectores = {4, 3, 6, 2};

    double sumaTotal = 0;

    for (double valor : vectores){
        sumaTotal+= Math.pow(valor,2);
    }
    IO.println(Math.sqrt(sumaTotal));
}
void main() {
    int[] buscados = {17, 23, 3};
    int[] lista = {8, 23, 30, 47, 17, 5, 17, 21, 2};

    int contador = 0;

    for (int list : lista){
        for(int busc : buscados){
            if (busc == list) {
                contador++;
            }
        }
    }
    IO.println(contador);
}
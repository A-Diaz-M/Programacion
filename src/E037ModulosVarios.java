void main() {
    for (int i = 0; i <= 49; i++) {

        String palabra;
        if (i % 7 == 0){
            palabra = "SÍ";
        } else {
            palabra = "NO";
        }
        IO.println(String.format("Vamos por el número %d. %d módulo 5 es %d. El número %s es múltiplo de 7.", i, i, (i%5), palabra));
    }
}
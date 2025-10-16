void main() {
    IO.println("ELEFANTES");
    String nombre = IO.readln("Dime como te llamas:\n");

    int num = Integer.parseInt(IO.readln(nombre+", introduzca un numero:\n"));

    String frase1;
    String frase2;

    for (int i = 1; i <= num; i++){
        frase1 = "elefante";
        frase2 = "balanceaba";
        if (i > 1){
            frase1 = "elefantes";
            frase2 = "balanceaban";
            if (i > num * 0.75){
                frase1 = "ELEFANTES";
                frase2 = "BALANCEABAN";
            }
        }
        System.out.format("Había una vez %d %s que se %s en una hamaca a la orilla de un río...\n", i, frase1, frase2);
    }
}
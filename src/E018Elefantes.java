void main() {
    IO.println("ELEFANTES");
    String nombre = IO.readln("Dime como te llamas:\n");

    int num = Integer.parseInt(IO.readln(nombre+", introduzca un numero:\n"));

    for (int i = 1; i <= num; i++){
       boolean singular = (i == 1);

       String elefante = singular ? "elefante" : "elefantes";
       String balanceaba = singular ? "balanceaba" : "balanceaban";

       if (i >= num * 0.75) elefante = elefante.toUpperCase();

       IO.println(String.format("Había una vez %d %s que se %s en una hamaca a la orilla de un río...", i, elefante, balanceaba));
    }
}
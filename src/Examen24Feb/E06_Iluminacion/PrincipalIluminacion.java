package Examen24Feb.E06_Iluminacion;

public class PrincipalIluminacion {
    public static void main(String[] args) {
        // TODO Descomenta este código conforme vayas creando las clases Bombilla y Lampara


        // --- PRUEBA 1: UNA SOLA BOMBILLA ---
        System.out.println("--- TEST BOMBILLA INDIVIDUAL ---");
        Bombilla bombilla = new Bombilla();
        bombilla.encender();
        System.out.println("Bombilla encendida: " + bombilla.estaEncendida()); // Debería ser true
        bombilla.apagar();
        bombilla.conmutar();
        System.out.println("Tras conmutar: " + bombilla.estaEncendida()); // Probablemente será true, a no ser que hayamos tenido muy mala suerte con la vida útil


        for (int i = 0; i < 15; i++) {
            bombilla.conmutar();
        }
        System.out.println("Tras fundir la bombilla: " + bombilla.estaEncendida()); // Debería ser false


        // --- PRUEBA 2: LÁMPARA COMPLETA ---
        System.out.println("\n--- TEST LÁMPARA (5 BOMBILLAS) ---");

        // Al crearse, cada bombilla tendrá una vida aleatoria entre 2 y 10 usos.
        Lampara lampara = new Lampara(5);

        System.out.println("Encendiendo todas...");
        lampara.encenderTodas();
        System.out.println("Iluminación actual: " + lampara.obtenerPorcentajeIluminacion() + "%");

        System.out.println("Apagando y encendiendo varias veces para forzar fundidos...");

        for (int i = 0; i < 15; i++) {
            lampara.conmutarBombilla(3);
        }


        // Realizamos ciclos para gastar la vida útil aleatoria
        for (int i = 0; i < 15; i++) {
            lampara.apagarTodas();
            lampara.encenderTodas();
        }


        System.out.println("Iluminación final (debería ser 0.0 o cercano): " + lampara.obtenerPorcentajeIluminacion() + "%");

    }
}
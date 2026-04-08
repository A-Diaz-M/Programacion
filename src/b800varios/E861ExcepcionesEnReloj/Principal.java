package b800varios.E861ExcepcionesEnReloj;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        // Un reloj en 23:57 al que el usuario suma minutos en bucle hasta conseguir una operación válida.

        System.out.println("ejemplo del mindmap 1");

        Scanner teclado = new Scanner(System.in);
        Reloj reloj = new Reloj(23, 57);
        boolean operacionOK = false;

        System.out.println("Valor inicial: " + reloj + "\n");

        do {
            try {
                System.out.print("Indica los minutos que quieres sumar (positivo): ");
                int minutos = teclado.nextInt();
                reloj.sumarMinutos(minutos);
                operacionOK = true;
            } catch (DesbordamientoRelojException e) {
                if (e.isSuperior())
                    System.out.println("  ✗ Te has salido del día por arriba. Inténtalo de nuevo.");
                else
                    System.out.println("  ✗ Te has salido del día por abajo. Inténtalo de nuevo.");
            } catch (OperacionNegativaRelojException e) {
                System.out.println("  ✗ " + e.getMessage() + " Inténtalo de nuevo.");
            }
        } while (!operacionOK);

        System.out.println("\nValor final tras suma válida: " + reloj + "\n");

        // Intentar restar minutos negativos y luego restar demasiados, demostrando los dos tipos de excepción desde restarMinutos().
        System.out.println("── BLOQUE 2: restarMinutos con entradas erróneas ──────");

        Reloj relojB = new Reloj(1, 10);  // 01:10
        System.out.println("Reloj de prueba: " + relojB);

        // Intento 1: minutos negativos
        try {
            relojB.restarMinutos(-5);
        } catch (OperacionNegativaRelojException e) {
            System.out.println("  ✗ OperacionNegativaRelojException: " + e.getMessage());
        } catch (DesbordamientoRelojException e) {
            System.out.println("  ✗ DesbordamientoRelojException (inesperado aquí)");
        }

        // Intento 2: restar demasiado (salida por abajo)
        try {
            relojB.restarMinutos(200);  // 01:10 − 200 min = negativo
        } catch (DesbordamientoRelojException e) {
            System.out.println("  ✗ DesbordamientoRelojException (superior=" + e.isSuperior() + "): "
                    + e.getMessage());
        } catch (OperacionNegativaRelojException e) {
            System.out.println("  ✗ OperacionNegativaRelojException (inesperado aquí)");
        }

        // Intento 3: resta válida
        try {
            relojB.restarMinutos(30);
            System.out.println("  ✓ Resta correcta. Reloj ahora: " + relojB);
        } catch (DesbordamientoRelojException | OperacionNegativaRelojException e) {
            System.out.println("  ✗ " + e.getMessage());
        }
        System.out.println();

        // Bucle interactivo completo (sumar Y restar). El usuario elige la operación y el programa gestiona ambas excepciones mostrando mensajes contextuales.

        System.out.println("── BLOQUE 3: consola interactiva ──────────────────────");
        System.out.println("  Controla el reloj. Escribe:");
        System.out.println("  + N  → sumar N minutos  (ej: + 30)");
        System.out.println("  - N  → restar N minutos (ej: - 45)");
        System.out.println("  q    → salir\n");

        Reloj relojC = new Reloj(12, 0);
        System.out.println("Reloj inicial: " + relojC);

        boolean salir = false;
        while (!salir) {
            System.out.print("\n> ");
            String linea = teclado.next();

            if (linea.equalsIgnoreCase("q")) {
                salir = true;
            } else if (linea.equals("+") || linea.equals("-")) {
                int n = teclado.nextInt();
                try {
                    if (linea.equals("+")) {
                        relojC.sumarMinutos(n);
                        System.out.println("  ✓ Resultado: " + relojC);
                    } else {
                        relojC.restarMinutos(n);
                        System.out.println("  ✓ Resultado: " + relojC);
                    }
                } catch (OperacionNegativaRelojException e) {
                    System.out.println("  ✗ Valor negativo no permitido: " + e.getMessage());
                } catch (DesbordamientoRelojException e) {
                    String direccion = e.isSuperior() ? "por arriba (≥ 24:00)" : "por abajo (< 00:00)";
                    System.out.println("  ✗ El reloj se saldría del día " + direccion + ". Operación cancelada.");
                    System.out.println("     El reloj sigue en: " + relojC);
                }
            } else {
                System.out.println("  Comando no reconocido. Usa +, - o q.");
            }
        }
        System.out.println("\nReloj final: " + relojC);
    }
}
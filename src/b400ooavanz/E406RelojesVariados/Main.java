package b400ooavanz.E406RelojesVariados;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== RelojDigital ===");
        RelojDigital relojD1 = new RelojDigital();
        RelojDigital relojD2 = new RelojDigital(150);// 2h 30m
        RelojDigital relojD3 = new RelojDigital(3, 45);

        System.out.println("RelojDigital 1: " + relojD1);// 08:15
        System.out.println("RelojDigital 2: " + relojD2);// 02:30
        System.out.println("RelojDigital 3: " + relojD3);// 03:45

        System.out.println();

        relojD1.tick();
        relojD1.sumarMinutos(80);
        System.out.println("RelojDigital 1 tras tick y +80 min: " + relojD1);
        System.out.println();

        relojD1.restarMinutos(20000);
        System.out.println("RelojDigital 1 tras restados 20000 min:  " + relojD1);
        System.out.println();

        int difMin = relojD2.diferenciaMinutos(relojD3);
        System.out.println("Diferencia en minutos (RelojDigital 1 - RelojDigital 2): " + difMin);
        System.out.println();

        Reloj difReloj = relojD2.diferenciaReloj(relojD3);
        System.out.println("Diferencia como Reloj de RelojDigital 2 y RelojDigital 3: " + difReloj);
        System.out.println();

        RelojDigital clon = relojD1.clone();
        System.out.println("RelojDigital 1: " + relojD1 + "  |  clon: " + clon
            + "  |  equals: " + relojD1.equals(clon));

        System.out.println();
        System.out.println("=== RelojEspañol ===");
        RelojEspañol relojE1 = new RelojEspañol(7, 53);
        RelojEspañol relojE2 = new RelojEspañol(1, 1);
        RelojEspañol relojE3 = new RelojEspañol(0, 0);
        System.out.println("RelojEspañol 1: " + relojE1);   // siete horas, cincuenta y tres minutos
        System.out.println("RelojEspañol 2: " + relojE2);   // una hora, un minuto
        System.out.println("RelojEspañol 3: " + relojE3);   // cero horas, cero minutos

        System.out.println();
        System.out.println("=== RelojIngles ===");
        RelojIngles relojI1 = new RelojIngles(7, 53);
        RelojIngles relojI2 = new RelojIngles(1, 1);
        RelojIngles relojI3 = new RelojIngles(22, 45);
        System.out.println("RelojIngles 1: " + relojI1);
        System.out.println("RelojIngles 2: " + relojI2);
        System.out.println("RelojIngles 3: " + relojI3);

        System.out.println();
        System.out.println("=== RelojAnalogico ===");

        System.out.println("-- 12:00 (solo horas, sin minutos) --");
        System.out.println(new RelojAnalogico(0, 0));

        System.out.println("-- 3:00 --");
        System.out.println(new RelojAnalogico(3, 0));

        System.out.println("-- 7:53 (horas + minutos) --");
        System.out.println(new RelojAnalogico(7, 53));

        System.out.println("-- 22:31 --");
        System.out.println(new RelojAnalogico(22, 31));
    }
}

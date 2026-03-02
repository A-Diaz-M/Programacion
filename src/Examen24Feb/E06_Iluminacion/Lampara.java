package Examen24Feb.E06_Iluminacion;

import java.util.ArrayList;

public class Lampara {
    public int Estado = 0;
    public ArrayList<Bombilla> todasBombi = new ArrayList<>();

    public Lampara(int bombi) {
        for (int i = 0; i < bombi; i++) {
            todasBombi.add(new Bombilla());
        }
    }

    public void encenderTodas() {
        for (Bombilla n : todasBombi) {
            n.encender();
        }
        Estado = 1;
    }

    public void apagarTodas() {
        for (Bombilla n : todasBombi) {
            n.apagar();
        }
        Estado = 0;
    }

    public void conmutarBombilla(int indice) {
        if (indice >= 0 && indice < todasBombi.size()) {
            todasBombi.get(indice).conmutar();
        }
    }

    public double obtenerPorcentajeIluminacion() {
        double contadorEncend = 0;
        for (Bombilla n : todasBombi) {
            if (n.estaEncendida() == "Si") {
                contadorEncend++;
            }
        }
        return (contadorEncend / todasBombi.size()) * 100;
    }
}
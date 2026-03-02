package Examen24Feb.E06_Iluminacion;

public class Bombilla {
    public int Estado = 0;
    public int vida;
    public boolean fundida = false;

    public Bombilla() {
        vida = (int) (Math.random() * 9) + 2;
        Estado = 0;
    }

    public void encender() {
        if (fundida) return;
        if (Estado == 0) {
            vida--;
            if (vida <= 0) {
                fundida = true;
                Estado = 0;
            } else {
                Estado = 1;
            }
        }
    }

    public void apagar() {
        if (fundida) return;
        if (Estado == 1) {
            vida--;
            if (vida <= 0) fundida = true;
            Estado = 0;
        }
    }

    public void conmutar() {
        if (fundida) return;
        if (Estado == 1) {
            apagar();
        } else {
            encender();
        }
    }

    public String estaEncendida() {
        return (Estado == 1 && !fundida) ? "Si" : "No";
    }
}
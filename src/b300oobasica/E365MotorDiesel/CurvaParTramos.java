package b300oobasica.E365MotorDiesel;

public class CurvaParTramos implements EstrategiaCurvaPar {

    @Override
    public double calcularPar(double rpm) {
        if (rpm >= 800  && rpm < 1500) return 150.0;
        if (rpm >= 1500 && rpm < 2500) return 350.0;
        if (rpm >= 2500 && rpm < 4500) return 200.0;
        return 0.0; // fuera del rango operativo
    }
}
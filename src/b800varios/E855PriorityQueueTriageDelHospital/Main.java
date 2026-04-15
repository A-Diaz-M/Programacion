package b800varios.E855PriorityQueueTriageDelHospital;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Paciente> pacientes = new PriorityQueue<>();

        pacientes.offer(new Paciente("Elena", "Brazo roto", Gravedad.URGENTE));
        pacientes.offer(new Paciente("Marcos", "Dolor de garganta", Gravedad.LEVE));
        pacientes.offer(new Paciente("Sofia", "Ataque cardiaco", Gravedad.CRITICO));
        pacientes.offer(new Paciente("Luis", "Fiebre alta", Gravedad.URGENTE));
        pacientes.offer(new Paciente("Carmen", "Corte leve", Gravedad.LEVE));
        pacientes.offer(new Paciente("Jorge", "Dificultad para respirar", Gravedad.CRITICO));

        while (!pacientes.isEmpty()) {
            Paciente pacienteActual = pacientes.poll();
            System.out.println("Paciente actual: " + pacienteActual);

            if (Math.random() < 0.30) {
                Gravedad[] niveles = Gravedad.values();
                Gravedad nivelAleatorio = niveles[(int)(Math.random() * niveles.length)];
                Paciente pacienteNuevo = new Paciente("Nombre", "Sintoma", nivelAleatorio);
                pacientes.offer(pacienteNuevo);
                System.out.println("\nNuevo paciente: " + pacienteNuevo);
                System.out.println();
            }
        }
    }
}
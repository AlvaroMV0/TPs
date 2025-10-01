package Memento;

public class MainMemento {
    public static void main(String[] args) {


        System.out.println("\n--- Comienzo del Memento ---");

        // NO colocamos el new dado que el memento va a ser creado con save
        Memento estadoGuardado;

        Examen examen = new Examen();

        // El alumno responde algunas preguntas.
        examen.responderPregunta("a");
        examen.responderPregunta("c");
        System.out.println("Progreso actual del examen: " + examen.getRespuestas());

        // Se guarda el estado actual.
        System.out.println("\n>> Guardando progreso...");
        estadoGuardado = examen.save();

        // El alumno continúa con el examen
        examen.responderPregunta("d");
        System.out.println("Progreso antes de guardar: " + examen.getRespuestas());

        // Restablecemos el memento.
        System.out.println("\n>> Restaurando al punto anterior...");
        examen.restore(estadoGuardado);

        // Se comprueba que el estado del examen ha vuelto al punto guardado.
        System.out.println("Progreso restaurado: " + examen.getRespuestas());

        System.out.println("\n--- Fin del Memento ---");
    }
}
package State;

public class MainState {
    public static void main(String[] args) {


        System.out.println("\n--- Comienzo del State ---");

        System.out.println("\n--- Caso 1: Inscripción con legajo válido ---");
        Inscripcion inscripcionValida = new Inscripcion("3579");
        // Cambia de EnEspera a Inscrito
        inscripcionValida.inscribir();
        System.out.println("Estado final: " + inscripcionValida.getEstadoInscripcion().getClass().getSimpleName()+ ".");

        System.out.println("\n--- Caso 2: Inscripción con legajo NO válido ---");
        Inscripcion inscripcionInvalida = new Inscripcion("123456");
        // Cambia de EnEspera a Cancelado
        inscripcionInvalida.inscribir();
        System.out.println("Estado final: " + inscripcionInvalida.getEstadoInscripcion().getClass().getSimpleName()+ ".");

        System.out.println("\n--- Caso 3: Intentar procesar una inscripción ya aceptada ---");
        System.out.println("Estado actual: " + inscripcionValida.getEstadoInscripcion().getClass().getSimpleName()+ ".");
        // Intenta procesar desde el estado Inscrito
        inscripcionValida.inscribir();
        System.out.println("Estado final: " + inscripcionValida.getEstadoInscripcion().getClass().getSimpleName()+ ".");

        System.out.println("\n--- Caso 4: Intentar procesar una inscripción ya cancelada ---");
        System.out.println("Estado actual: " + inscripcionInvalida.getEstadoInscripcion().getClass().getSimpleName()+ ".");
        // Intenta procesar desde el estado Cancelado
        inscripcionInvalida.inscribir();
        System.out.println("Estado final: " + inscripcionInvalida.getEstadoInscripcion().getClass().getSimpleName()+ ".");

        System.out.println("\n--- Fin del State ---");
    }
}
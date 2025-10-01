package ChainOfResponsibility;

public class MainCom {

    public static void main(String[] args) {


        System.out.println("\n--- Inicio del Com ---");

        // 1. Instanciar los manejadores
        Handler asistente = new Asistente();
        Handler profesor = new Profesor();
        Handler coordinador = new Coordinador();

        // 2. Configurar la cadena de responsabilidad
        // Asistente -> Profesor -> Coordinador
        asistente.setNext(profesor);
        profesor.setNext(coordinador);


        System.out.println("--- Inicio del procesamiento de solicitudes ---");

        // Esta solicitud debe ser manejada por el Asistente
        Solicitud solicitudFacil = new Solicitud(1, "Consulta de horario de clases", "Detalle...");
        System.out.println("\nProcesando solicitud de nivel 1...");
        asistente.handle(solicitudFacil);

        // Esta solicitud será pasada por el Asistente y manejada por el Profesor
        Solicitud solicitudMedia = new Solicitud(2, "Justificar inasistencia por enfermedad", "Detalle...");
        System.out.println("\nProcesando solicitud de nivel 2...");
        asistente.handle(solicitudMedia);

        // Esta solicitud pasará por Asistente, Profesor y será manejada por el Coordinador
        Solicitud solicitudDificil = new Solicitud(3, "Solicitud de cambio de comisión", "Detalle...");
        System.out.println("\nProcesando solicitud de nivel 3...");
        asistente.handle(solicitudDificil);

        // Esta solicitud pasará por toda la cadena y nadie podrá manejarla
        Solicitud solicitudImposible = new Solicitud(4, "Revisión de nota final de la carrera", "Detalle...");
        System.out.println("\nProcesando solicitud de nivel 4...");
        asistente.handle(solicitudImposible);

        System.out.println("\n--- Fin del Com ---");

    }
}
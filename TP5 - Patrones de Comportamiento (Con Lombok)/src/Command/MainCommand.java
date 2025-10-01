package Command;



public class MainCommand {
    public static void main(String[] args) {


        System.out.println("\n--- Inicio del Command ---");


        Plataforma plataforma = new Plataforma();
        AlumnoInvoker alumno = new AlumnoInvoker();

        Command inscribir = new InscribirseCursoCommand(plataforma, "Patrones de Diseño");
        Command certificado = new SolicitarCertificadoCommand(plataforma, "Matemáticas");

        alumno.setComando(inscribir);
        alumno.enviarSolicitud();

        alumno.setComando(certificado);
        alumno.enviarSolicitud();

        System.out.println("\n--- Fin del Command ---");


    }
}

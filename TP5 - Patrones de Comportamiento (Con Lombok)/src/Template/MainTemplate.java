package Template;

public class MainTemplate {
    public static void main(String[] args) {

        System.out.println("\n--- Inicio del Template ---");

        System.out.println("Generando reporte para un Alumno:");
        ReporteAcademico reporteAlumno = new ReporteAlumno("12345");
        reporteAlumno.generarReporte();

        System.out.println("\nGenerando reporte para un Curso:");
        ReporteAcademico reporteCurso = new ReporteCurso("CS101");
        reporteCurso.generarReporte();

        System.out.println("\n--- Fin del Template ---");

    }
}

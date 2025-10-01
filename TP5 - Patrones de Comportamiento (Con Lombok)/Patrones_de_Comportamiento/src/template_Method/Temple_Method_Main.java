package template_Method;

public class Temple_Method_Main {
    public static void main(String[] args){
        //Tipos de cursos: Presencial, Online o Hibrido
        ReporteAcademico reporteCurso1 = ReporteCurso.builder().tipoCurso("Presencial").build();
        ReporteAcademico reporteCurso2 = ReporteCurso.builder().tipoCurso("Online").build();
        ReporteAcademico reporteCurso3 = ReporteCurso.builder().tipoCurso("Hibrido").build();
        ReporteAcademico reporteAlumno = ReporteAlumno.builder().build();

        System.out.println("===Escribiendo reporte de curso");
        reporteCurso1.escribirReporte();
        System.out.println("===Escribiendo reporte de curso");
        reporteCurso2.escribirReporte();
        System.out.println("===Escribiendo reporte de curso");
        reporteCurso3.escribirReporte();
        System.out.println("===Escribiendo reporte de alumno");
        reporteAlumno.escribirReporte();
    }
}

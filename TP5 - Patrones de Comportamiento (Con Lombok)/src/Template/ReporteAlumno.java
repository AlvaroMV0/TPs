package Template;

public class ReporteAlumno extends ReporteAcademico {
    private final String legajoAlumno;

    public ReporteAlumno(String legajoAlumno) {
        this.legajoAlumno = legajoAlumno.trim();
    }

    @Override
    protected void buscarEnBd() {
        System.out.println("Buscando al alumno legajo: '" + legajoAlumno + "' en la base de datos...");
        System.out.println("Alumno encontrado.");

    }
}

package Template;

class ReporteCurso extends ReporteAcademico {
    private String idCurso;

    public ReporteCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    protected void buscarEnBd() {
        System.out.println("Buscando al curso : '" + this.idCurso + "' en la base de datos...");
        System.out.println("Curso encontrado. Datos recopilados.");
    }
}

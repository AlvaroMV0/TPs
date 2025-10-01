package Visitor;

class ReporteFinanciero implements Visitor {
    @Override
    public void visitar(AlumnoRegular a) {
        System.out.println("  - Reporte Financiero: Alumno Regular " + a.getNombre() + " debe la cuota completa.");
    }

    @Override
    public void visitar(AlumnoBecado a) {
        System.out.println("  - Reporte Financiero: Alumno Becado " + a.getNombre() + " no tiene deuda, cubierto por beca.");
    }
}
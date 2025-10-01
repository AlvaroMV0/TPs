package Visitor;

import java.util.Arrays;
import java.util.List;

public class MainVisitor {
    public static void main(String[] args) {
        List<AlumnoElement> alumnos = Arrays.asList(
                new AlumnoRegular("Pedro"),
                new AlumnoBecado("Laura", 0.50),
                new AlumnoRegular("Sofía"));
        Visitor aplicarBeca = new AplicarBeca();
        Visitor reporteFinanciero = new ReporteFinanciero();

        System.out.println("=== Aplicando Beneficios ===");
        for (AlumnoElement a : alumnos) { a.aceptar(aplicarBeca); }

        System.out.println("\n=== Generando Reporte Financiero ===");
        for (AlumnoElement a : alumnos) { a.aceptar(reporteFinanciero); }
    }
}

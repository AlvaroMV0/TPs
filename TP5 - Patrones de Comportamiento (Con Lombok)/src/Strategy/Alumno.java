package Strategy;

import java.util.List;

public class Alumno {
    private CalculoNota estrategia;
    private List<Integer> notas;

    public Alumno(CalculoNota estrategia, List<Integer> notas) {
        this.estrategia = estrategia;
        this.notas = notas;
    }

    public void setEstrategia(CalculoNota estrategia) {
        this.estrategia = estrategia;
    }

    public void calcularNotaFinal() {
        double notaFinal = estrategia.calcular(notas);
        System.out.println("Nota final calculada con " + estrategia.getClass().getSimpleName() + ": " + String.format("%.2f", notaFinal));
    }
}
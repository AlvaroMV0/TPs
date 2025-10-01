package Strategy;

import java.util.Arrays;
import java.util.List;

public class MainStrategy {
    public static void main(String[] args) {
        List<Integer> notas = Arrays.asList(70, 85, 90, 65);
        Alumno maria = new Alumno(new PromedioSimple(), notas);

        maria.calcularNotaFinal(); // Usa promedio simple

        maria.setEstrategia(new PromedioPonderado());
        maria.calcularNotaFinal(); // Usa promedio ponderado

        maria.setEstrategia(new ExamenExtra());
        maria.calcularNotaFinal(); // Usa examen extra
    }
}
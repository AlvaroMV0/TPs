package Strategy;

import java.util.ArrayList;
import java.util.List;

class ExamenExtra implements CalculoNota{
    @Override
    public double calcular(List<Integer> notas) {
        // Se elimina la nota más baja y se calcula el promedio simple
        if (notas.isEmpty()) return 0;
        List<Integer> notasAux = new ArrayList<>(notas);
        if (notasAux.size() > 1) {
            notasAux.remove(java.util.Collections.min(notasAux));
        }
        return new PromedioSimple().calcular(notasAux);
    }
}
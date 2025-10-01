package Strategy;

import java.util.List;

class PromedioSimple implements CalculoNota{
    @Override
    public double calcular(List<Integer> notas){
        double suma = notas.stream().mapToInt(Integer::intValue).sum();
        return suma / notas.size();
    }
}

package strategy;

import java.util.List;

public class PromedioSimple implements CalculoNota{
    @Override
    public Integer Calcular(List<Integer> notas,List<Float> pesos) {
        Integer resultado = 0;
        for(Integer n: notas){
            resultado += n;
        }
        return Math.round(resultado/notas.size());
    }
}

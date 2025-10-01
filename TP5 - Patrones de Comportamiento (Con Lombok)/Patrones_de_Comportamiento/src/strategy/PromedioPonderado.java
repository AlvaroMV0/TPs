package strategy;

import java.util.List;

public class PromedioPonderado implements CalculoNota {
    @Override
    public Integer Calcular (List<Integer> notas,List<Float> pesos) {
        float resultado = 0;
        int i=0;
        for(Integer n: notas){
                resultado += n*pesos.get(i);
                i++;
            }
        return Math.round(resultado);
    }
}


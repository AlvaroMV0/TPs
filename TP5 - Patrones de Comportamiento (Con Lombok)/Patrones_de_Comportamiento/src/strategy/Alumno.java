package strategy;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

public class Alumno {
    private List<Integer> notas = new ArrayList<>();
    private List<Float> pesos = new ArrayList<>();
    @Setter
    private CalculoNota calculoNota;

    public void addNota(Integer nota){
        notas.add(nota);
    }

    public void addPeso(Float peso){
        pesos.add(peso);
    }

    public void CalcularNota(){
        System.out.println("Nota " + calculoNota.Calcular(notas,pesos));
    }

}

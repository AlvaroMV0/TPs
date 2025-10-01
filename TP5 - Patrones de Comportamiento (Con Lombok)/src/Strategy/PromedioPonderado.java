package Strategy;

import java.util.List;

class PromedioPonderado implements CalculoNota{
    @Override
    public double calcular(List<Integer> notas){
        //Asumiendo que la primera nota tiene peso 30% y las demás 70%
        if(notas.isEmpty()) return 0;
        if (notas.size() == 1) return notas.getFirst();

        double peso1 = notas.getFirst()*0.3;
        double sumaResto = 0;
        for (int i = 1; i<notas.size();i++){
            sumaResto += notas.get(i);
        }
        double promedioResto = sumaResto / (notas.size()-1);
        return  peso1 + (promedioResto*0.7);
    }
}
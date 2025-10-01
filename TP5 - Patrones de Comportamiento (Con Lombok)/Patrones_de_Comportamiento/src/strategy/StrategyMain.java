package strategy;

public class StrategyMain {
    public static void main(String[] args){
        Alumno alumno = new Alumno();

        alumno.addNota(5);
        alumno.addNota(5);
        alumno.addNota(10);

        alumno.setCalculoNota(new PromedioSimple());

        alumno.CalcularNota();

        alumno.setCalculoNota(new PromedioPonderado());
        alumno.addPeso(0.2f);
        alumno.addPeso(0.2f);
        alumno.addPeso(0.6f);
        alumno.CalcularNota();
    }
}

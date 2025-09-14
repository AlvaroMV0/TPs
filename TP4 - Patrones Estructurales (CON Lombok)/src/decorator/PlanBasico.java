package decorator;


// Componente concreto, no tiene porque ser único, pero de este plan básico vamos agregando lo que el usuario desee

public class PlanBasico implements Plan {
    @Override
    public String descripcion() {
        return "Plan básico";
    }

    @Override
    public double costo() {
        return 1000;
    }
}

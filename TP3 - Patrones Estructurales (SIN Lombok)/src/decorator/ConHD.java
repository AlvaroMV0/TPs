package decorator;

//Decorador concreto, hereda del decorador abstracto e implementa su propia funcionalidad, en este caso agregar HD
public class ConHD extends PlanDecorador{

    public ConHD ( Plan plan){
        super(plan);
    }

    @Override
    public String descripcion() {
        return plan.descripcion()+" + HD";
    }

    @Override
    public double costo() {
        return plan.costo() + 500;
    }
}

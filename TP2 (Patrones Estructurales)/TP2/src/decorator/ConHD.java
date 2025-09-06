package decorator;

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

package decorator;




//Decorador concreto, hereda del decorador abstracto e implementa su propia funcionalidad, en este caso agregar ConDescargasOffilne
public class ConDescargasOffline extends PlanDecorador{

    public ConDescargasOffline (Plan plan){
        super(plan);
    }

    @Override
    public String descripcion() {
        return plan.descripcion()+" + DescargasOffline";
    }

    @Override
    public double costo() {
        return plan.costo() + 700;
    }
}

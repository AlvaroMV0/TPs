package decorator;

//Decorador abstracto, no tiene una implementación directa, los decoradores concretos heredan de esta clase para implementar sus funcionaldiades

public class PlanDecorador implements Plan{

    protected Plan plan;


    // Constructor que recibe el componente a decorar, que puede ser un componente concreto (PlanBasico) u otro decorador.
    // Recibir otro decorador sucede cuando "le agregamos" otro detalle al plan.

    public PlanDecorador(Plan plan){
        this.plan = plan;
    }

    //Como es un decorador abstracto los métodos inciales no se ven modificados, estos dos metodos podrán ser sobreescritos
    @Override
    public String descripcion() {
        return plan.descripcion();
    }

    @Override
    public double costo() {
        return plan.costo();
    }
}

package decorator;

public class DecoratorMain {
    public static void main(String[] args) {


        System.out.println("\n\n- - - - - Patrón Decorator - - - - -\n");

        // Creamos el componente concreto: el plan básico.
        Plan plan = new PlanBasico();

        // Le agregamos HD. La variable 'plan' ahora apunta a un objeto ConHD que "envuelve" al componente concreto PlanBasico.
        plan = new ConHD(plan);

        // Le agregamos la funcionalidad de descargas offline, envolviendo al decorador anterior.
        plan = new ConDescargasOffline(plan);

        // Imprimimos la descripción final y el costo total.
        System.out.println("Descripción: " + plan.descripcion());
        System.out.println("Costo final: $" + plan.costo());



    }
}

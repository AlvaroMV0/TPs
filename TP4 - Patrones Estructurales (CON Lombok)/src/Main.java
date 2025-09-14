import adapter.AdapterMain;
import bridge.BridgeMain;
import composite.CompositeMain;
import decorator.DecoratorMain;
import facade.FacadeMain;
import flyweight.FlyweightMain;
import proxy.ProxyMain;

public class Main {
    public static void main(String[] args) {

        //1- Patron Adapter
        AdapterMain.main(null);
        System.out.println("\n-----------");
        // ----


        //2- Bridge
        BridgeMain.main(null);
        System.out.println("\n-----------");
        // ----


        //3- Patron Decorator
        DecoratorMain.main(null);
        System.out.println("\n-----------");
        // ----


        //4- Facade
        FacadeMain.main(null);
        System.out.println("\n-----------");
        // ----


        //5- Flyweight
        FlyweightMain.main(null);
        System.out.println("\n-----------");
        // ----


        //6- Proxy
        ProxyMain.main(null);
        System.out.println("\n-----------");
        // ----


        //7- Composite
        CompositeMain.main(null);
        System.out.println("\n-----------");
        // ----


        System.out.println("\n\nFIN del programa...\n\n");
    }
}
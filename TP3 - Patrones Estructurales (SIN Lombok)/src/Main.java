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
        // ----


        //2- Bridge
        BridgeMain.main(null);
        // ----


        //3- Patron Decorator
        DecoratorMain.main(null);
        // ----


        //4- Facade
        FacadeMain.main(null);
        // ----

        //TODO: Descomentar para poder ver
        //5- Flyweight
        FlyweightMain.main(null);
        // ----


        //6- Proxy
        ProxyMain.main(null);
        // ----


        //7- Composite
        CompositeMain.main(null);
        // ----
    }
}
package facade;

public class FacadeMain {
    public static void main(String[] args) {
        System.out.println("\n\n- - - - - Patrón Facade - - - - -\n");

        TiendaFacade tienda = new TiendaFacade();


        tienda.comprar("Lavarropas");
    }
}

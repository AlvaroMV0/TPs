package facade;

public class FacadeMain {
    public static void main(String[] args) {
        System.out.println("\n\n- - - - - Patrón Facade - - - - -\n");
        Carrito carrito = new Carrito();
        Envio envio = new Envio();
        Pago pago = new Pago();

        TiendaFacade tienda = new TiendaFacade(carrito, pago, envio);


        tienda.comprar("Lavarropas");
    }
}

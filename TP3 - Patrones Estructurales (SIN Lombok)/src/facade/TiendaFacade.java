package facade;

public class TiendaFacade {

    // Simplifica el proceso de compra al ocultar la complejidad de los subsistemas
    // (Carrito, Pago, Envio) y exponer un único método 'comprar()' al cliente.

    private Carrito carrito;
    private Pago pago;
    private Envio envio;

    public TiendaFacade (){
        this.carrito = new Carrito();
        this.envio = new Envio();
        this.pago = new Pago();
    }

    public void comprar(String articulo){
        carrito.GestionarProductos(articulo);
        pago.RealizarPago(articulo);
        envio.RealizarEnvio(articulo);
        System.out.println("El objeto " +articulo+ " fue comprado con éxito");
    }
}

package facade;

public class TiendaFacade {
    /**
     * Proporciona una interfaz simplificada (una fachada) para gestionar el complejo
     * proceso de compra que involucra múltiples subsistemas.
     * <p>
     * Cada una de las clases (Carrito, Pago y Envio) implementa su propia
     * funcionalidad. TiendaFacade se encarga de orquestar estas clases, decidiendo
     * a quién llamar primero, qué atributos pasar, etc.
     * <p>
     * De esta manera, el cliente (por ejemplo, el método main) simplemente necesita
     * crear un objeto de esta fachada y llamar a su método principal {@code comprar()}.
     */

    private Carrito carrito;
    private Pago pago;
    private Envio envio;

    public TiendaFacade (Carrito carrito, Pago pago, Envio envio){
        this.carrito = carrito;
        this.pago = pago;
        this.envio = envio;
    }

    public void comprar(String articulo){
        carrito.GestionarProductos(articulo);
        pago.RealizarPago(articulo);
        envio.RealizarEnvio(articulo);
        System.out.println("El objeto " +articulo+ " fue comprado con éxito");
    }
}

package Observer;
//e permite definir un mecanismo de suscripción
//para notificar a varios objetos sobre cualquier
// evento que le suceda al objeto que están observando.
public interface Observer {
    void update(String msg);
}

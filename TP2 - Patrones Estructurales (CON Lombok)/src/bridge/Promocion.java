package bridge;
// extiende la abstracción para definir un tipo específico de notificación.
public class Promocion extends Notificacion {
    public Promocion (CanalEnvio canal){
        super(canal);
    }
    @Override
    public void enviar(){
        canal.enviarMensaje("Nueva Promoción", "2x1 en nuestro MEGA COMBO BURGER !Entra ya¡");
    }
}

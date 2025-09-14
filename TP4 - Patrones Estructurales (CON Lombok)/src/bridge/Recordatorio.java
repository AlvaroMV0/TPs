package bridge;

// extiende la abstracción para definir un tipo específico de notificación.
public class Recordatorio extends Notificacion {
    public Recordatorio(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void enviar() {
        canal.enviarMensaje("Recordatorio", "No olvide la reunión de mañana a las 10AM.");
    }
}

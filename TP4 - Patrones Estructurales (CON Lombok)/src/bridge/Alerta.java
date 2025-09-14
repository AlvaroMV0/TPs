package bridge;

// extiende la abstracción para definir un tipo específico de notificación.
public class Alerta extends Notificacion {
    public Alerta(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void enviar() {
        canal.enviarMensaje("ALERTA URGENTE", " Hay un problema critico en el sistema.");

    }
}

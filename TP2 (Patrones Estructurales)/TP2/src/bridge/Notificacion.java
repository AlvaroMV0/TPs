package bridge;
// Separa las clases para que tenga jerarquías separadas que se conectan por un puente(bridge)
public abstract class Notificacion {
    protected CanalEnvio canal;

    public Notificacion (CanalEnvio canal){

        this.canal = canal;
    }
    public abstract void enviar();
}

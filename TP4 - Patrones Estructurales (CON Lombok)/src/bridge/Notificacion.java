package bridge;

import lombok.RequiredArgsConstructor;

// Separa las clases para que tenga jerarquías separadas que se conectan por un puente(bridge)
@RequiredArgsConstructor
public abstract class Notificacion {

    protected final CanalEnvio canal;

    public abstract void enviar();
}

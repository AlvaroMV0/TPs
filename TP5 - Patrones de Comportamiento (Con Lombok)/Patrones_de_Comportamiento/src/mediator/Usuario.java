package mediator;

import lombok.experimental.SuperBuilder;

@SuperBuilder

public abstract class Usuario {
    protected ChatMediator chatMediator;
    protected String nombre;
    public abstract void enviar(String msg);
    protected abstract void recibir(String msg);
}

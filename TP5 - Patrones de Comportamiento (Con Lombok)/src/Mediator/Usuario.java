package Mediator;

import java.util.ArrayList;
import  java.util.List;

abstract class Usuario {
    protected ChatMediator mediator;
    protected String nombre;

    public Usuario(ChatMediator mediator, String nombre){
        this.mediator = mediator;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public abstract void enviar(String mensaje);
    public abstract void recibir(String mensaje);
}

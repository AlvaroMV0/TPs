package mediator;

import lombok.experimental.SuperBuilder;

@SuperBuilder

public class Profesor extends Usuario {
    @Override
    public void enviar(String msg) {
        System.out.println(nombre+" envió: "+msg);
        chatMediator.enviar(msg,this);
    }

    @Override
    public void recibir(String msg) {
        System.out.println(nombre+" recibe: "+msg);
    }
}

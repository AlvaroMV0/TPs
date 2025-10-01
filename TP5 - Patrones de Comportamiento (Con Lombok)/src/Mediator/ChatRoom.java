package Mediator;

import java.util.ArrayList;
import java.util.List;

class ChatRoom implements ChatMediator{
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public  void registrar(Usuario u){
        usuarios.add(u);
    }
    @Override
    public void enviar(String mensaje, Usuario emisor){
        for(Usuario u: usuarios){
            //No enviar al emisor
            if(u!=emisor){
                u.recibir("[Mensaje de "+emisor.getNombre() + "]: "+mensaje);
            }
        }
    }
}

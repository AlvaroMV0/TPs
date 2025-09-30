package mediator;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

public class ChatRoom implements ChatMediator{
    private List<Usuario> usuarios = new ArrayList<>();
    @Override
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void enviar(String msg, Usuario usuario) {
        for (Usuario u: usuarios){
            if (u != usuario) {
                u.recibir(msg);
            }
        }
    }
}

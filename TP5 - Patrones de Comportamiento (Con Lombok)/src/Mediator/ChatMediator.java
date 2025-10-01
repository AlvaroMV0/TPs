package Mediator;
//Ayuda a reducir las dependencias caóticas entre objetos
//Restringe las comunicaciones directas entre objetos
//forzandolos a colaborar unicamente a travrs de un
//objeto mediador

public interface ChatMediator {
    void enviar(String msg, Usuario u);
    void registrar(Usuario u);
}

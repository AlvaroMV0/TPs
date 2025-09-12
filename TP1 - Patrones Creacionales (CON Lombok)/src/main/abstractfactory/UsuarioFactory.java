package main.abstractfactory;

// Implementa la fábrica para crear la familia de objetos de Usuario.
public class UsuarioFactory implements BibliotecaFactory {
    @Override
    public InterfazUI crearUI(String tema) {
        return new UsuarioUI(tema);
    }

    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioNormal();
    }
}
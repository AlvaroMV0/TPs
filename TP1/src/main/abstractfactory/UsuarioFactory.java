package main.abstractfactory;

// Implementa la fábrica para crear la familia de objetos de Usuario.
public class UsuarioFactory implements AbstractFactory
{
    @Override
    public InterfazUI crearUI(String tipo) {
        return new UsuarioUI();
    }

    @Override
    public MetodoEnvio crearMetodoEnvio(String tipo) {
        return new EnvioNormal();
    }
}
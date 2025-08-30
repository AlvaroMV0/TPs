package main.abstractfactory;

public class AdminFactory implements BibliotecaFactory
{
    @Override
    public InterfazUI crearUI(String tema) {
        return new AdminUI(tema);
    }

    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioExpress();
    }
}

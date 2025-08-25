package main.abstractfactory;

public class AdminFactory implements AbstractFactory {
    @Override
    public InterfazUI crearUI(String tipo) {
        return new AdminUI();
    }

    @Override
    public MetodoEnvio crearMetodoEnvio(String tipo) {
        return new EnvioExpress();
    }
}

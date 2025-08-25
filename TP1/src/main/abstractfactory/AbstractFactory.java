package main.abstractfactory;

public interface AbstractFactory {
    InterfazUI crearUI(String tipo);
    MetodoEnvio crearMetodoEnvio(String tipo);
}
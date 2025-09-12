package main.abstractfactory;

public interface BibliotecaFactory
{
    InterfazUI crearUI(String tipo);
    MetodoEnvio crearMetodoEnvio();
}
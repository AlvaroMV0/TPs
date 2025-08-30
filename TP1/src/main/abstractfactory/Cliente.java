package main.abstractfactory;

import main.factory.Libro;

public class Cliente
{
    private final InterfazUI interfaz;
    private final MetodoEnvio envio;

    public Cliente(BibliotecaFactory factory,String tema)
    {
        interfaz = factory.crearUI(tema);
        envio = factory.crearMetodoEnvio();
    }

    public void usarSistema(Libro libro)
    {
        interfaz.mostrarUI();
        envio.enviar(libro.mostrarInfo());
    }

}

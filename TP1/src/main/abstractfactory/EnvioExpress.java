package main.abstractfactory;

public class EnvioExpress implements MetodoEnvio
{
    @Override
    public void calcularMetodoEnvio()
    {
        System.out.println("El envio es express");
    }
}

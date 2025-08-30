package main.abstractfactory;

public class EnvioExpress implements MetodoEnvio
{
    @Override
    public void enviar( String item )
    {
        System.out.println("El envio del item " + item + " es express");
    }
}

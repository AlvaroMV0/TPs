package main.abstractfactory;

public class EnvioNormal implements MetodoEnvio
{
    @Override
    public void calcularMetodoEnvio()
    {
        System.out.println("El envio es normal");
    }
}

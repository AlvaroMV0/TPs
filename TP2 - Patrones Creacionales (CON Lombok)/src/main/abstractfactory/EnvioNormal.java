package main.abstractfactory;

public class EnvioNormal implements MetodoEnvio {
    @Override
    public void enviar(String item) {
        System.out.println("El envio del item \"" + item + "\" es NO prioritario.");
    }
}

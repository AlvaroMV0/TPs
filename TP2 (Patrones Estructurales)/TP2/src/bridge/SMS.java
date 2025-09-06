package bridge;

public class SMS implements CanalEnvio {
    @Override
    public void enviarMensaje(String asunto, String mensaje){
        System.out.println("Enviando SMS - Mensaje: " + mensaje );
    }
}

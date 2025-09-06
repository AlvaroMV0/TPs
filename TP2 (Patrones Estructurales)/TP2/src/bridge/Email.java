package bridge;
// Esta clase contiene el código para enviar un mensaje por Email.
     public class Email implements CanalEnvio{
        @Override
        public void enviarMensaje (String asunto, String mensaje){
            System.out.println("Enviando Email - Asunto: " + asunto + "| Mensaje" + mensaje);
        }
}

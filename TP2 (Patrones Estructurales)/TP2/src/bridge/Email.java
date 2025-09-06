package bridge;

    class Email implements CanalEnvio{
        @Override
        public void enviarMensaje (String asunto, String mensaje){
            System.out.println("Enviando Email - Asunto: " + asunto + "| Mensaje" + mensaje);
        }
}

package bridge;

public class BridgeMain {
    public static void main(String[] args) {
        System.out.println("\n\n- - - - - Patrón Bridge - - - - -\n");

        CanalEnvio canalEmail = new Email();
        CanalEnvio canalSms = new SMS();

        // This specifies your class from your package
        Notificacion alertaPorEmail = new Alerta(canalEmail);
        alertaPorEmail.enviar();

        Notificacion alertaPorSms = new Alerta(new SMS());
        alertaPorSms.enviar();

        Notificacion recordatorioPorSms = new Recordatorio(new SMS());
        recordatorioPorSms.enviar();

        Notificacion recordatorioPorEMail = new Recordatorio(new Email());
        recordatorioPorEMail.enviar();

        Notificacion PromocionPorEmail = new Promocion(new Email());
        PromocionPorEmail.enviar();

        Notificacion PromocionPorSms = new Promocion(new SMS());
        PromocionPorSms.enviar();
    }
}

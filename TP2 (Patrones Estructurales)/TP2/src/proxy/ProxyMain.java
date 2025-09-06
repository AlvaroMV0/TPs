package proxy;

public class ProxyMain {
    public static void main(String[] args) {

        System.out.println("\n\n- - - - - Patrón Proxy - - - - -\n");

        System.out.println("--- Intento de usuario con permisos ---");
        Archivo archivoAdmin = new ArchivoProxy("datos_secretos.dat", "ADMIN");
        archivoAdmin.leer(); // Debería funcionar

        System.out.println("\n--- Intento de usuario sin permisos ---");
        Archivo archivoInvitado = new ArchivoProxy("datos_secretos.dat", "INVITADO");
        archivoInvitado.leer(); // Debería ser denegado

    }
}

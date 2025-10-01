package Mediator;

public class MainMediator {
    public static void main(String[] args) {


        ChatMediator chat = new ChatRoom();

        Usuario alumno1 = new Alumno(chat, "Ana");
        Usuario profesor1 = new Profesor(chat, "Dr. García");

        chat.registrar(alumno1);
        chat.registrar(profesor1);

        alumno1.enviar("Profesor, ¿hay clase mañana?");
        System.out.println("---");
        profesor1.enviar("Sí, la clase se mantiene a las 10:00.");
    }
}
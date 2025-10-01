package mediator;

public class MediatorMain {
    public static void main(String[] args){

        ChatMediator sala = new ChatRoom();

        Usuario profesor = Profesor.builder().chatMediator(sala).nombre("Profesor").build();
        Usuario alumno1 = Alumno.builder().chatMediator(sala).nombre("Alumno 1").build();
        Usuario alumno2 = Alumno.builder().chatMediator(sala).nombre("Alumno 2").build();

        sala.agregarUsuario(profesor);
        sala.agregarUsuario(alumno1);
        sala.agregarUsuario(alumno2);

        profesor.enviar("Mensaje de profesor");
        alumno1.enviar("Mensaje alumno");
    }
}

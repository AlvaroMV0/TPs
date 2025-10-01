package observer;

import java.time.LocalDateTime;

public class ObserverMain {
    public static void main(String[] args){
        Curso curso = new Curso();

        curso.addObservers(new Alumno("Alumno 1"));
        curso.addObservers(new Alumno("Alumno 2"));
        curso.addObservers(new Alumno("Alumno 3"));

        curso.setAviso("Nuevo Aviso");

        curso.setHorario(LocalDateTime.now());
    }
}

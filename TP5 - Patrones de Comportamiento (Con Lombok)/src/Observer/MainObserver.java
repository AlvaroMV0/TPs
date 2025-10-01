package Observer;

public class MainObserver {
    public static void main(String[] args) {
        Curso patrones = new Curso("Patrones de Diseño");
        Alumno ana = new Alumno("Ana");
        Alumno luis = new Alumno("Luis");

        patrones.addObserver(ana);
        patrones.addObserver(luis);

        patrones.cambiarHorario("Lunes y Miércoles 19:00");
        patrones.publicarAviso("Examen parcial la próxima semana.");
    }
}

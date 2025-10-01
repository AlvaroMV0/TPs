package iterator;

public class IteratorMain {
    public static void main(String[] args){

        Alumno alumno = Alumno.builder().nombre("Fran").build();

        alumno.addCurso(new Curso("Curso 1"));
        alumno.addCurso(new Curso("Curso 2"));
        alumno.addCurso(new Curso("Curso 3"));

        CursoIterador cursoIterador = alumno.cursoIterador();

        while (cursoIterador.hasNext()){
            System.out.println(cursoIterador.next().getNombre());
        }
    }
}

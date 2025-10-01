package Iterator;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder

public class Alumno {
    @Getter
    private String nombre;
    @Builder.Default
    private List<Curso> cursos = new ArrayList<>();

    public void addCurso(Curso curso){
        cursos.add(curso);
    }

    public CursoIterador cursoIterador(){
        return (cursos != null) ?  CursoIterador.builder().cursos(cursos).build() : null;
    }
}

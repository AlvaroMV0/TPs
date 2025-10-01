package Iterator;

import lombok.Builder;

import java.util.List;

@Builder

public class CursoIterador {
    private List<Curso> cursos;
    @Builder.Default
    private int posicion = 0;

    public boolean hasNext(){
        return posicion < cursos.size();
    }

    public Curso next(){
        return cursos.get(posicion++);
    }

}

package visitor;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class AlumnoBecado implements Alumno{

    @Override
    public void visitor(Visitor v){
        v.visitar(this);
    }

}
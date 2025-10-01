package visitor;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class AlumnoRegular implements Alumno{


    @Override
    public void visitor(Visitor v){
        v.visitar(this);
    }

}

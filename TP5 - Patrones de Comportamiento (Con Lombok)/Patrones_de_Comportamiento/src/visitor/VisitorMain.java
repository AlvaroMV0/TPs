package visitor;

public class VisitorMain {
    public static void main(String[] args){
        Alumno alumnoRegular = new AlumnoRegular();
        Alumno alumnoBecado = new AlumnoBecado();

        Visitor aplicarBeca = new AplicarBeca();

        alumnoRegular.visitor(aplicarBeca);
        alumnoBecado.visitor(aplicarBeca);
    }
}

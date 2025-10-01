package visitor;

public class AplicarBeca implements Visitor{
    @Override
    public void visitar(AlumnoRegular a) {
        System.out.println("No se puede aplicar beca a alumno no becado");
    }
    @Override
    public void visitar(AlumnoBecado a) {
        System.out.println("Calculando beneficios de beca");
    }
}

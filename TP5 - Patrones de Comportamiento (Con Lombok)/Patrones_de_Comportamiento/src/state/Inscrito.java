package state;

public class Inscrito implements EstadoInscripcion{
    @Override
    public void Cancelar(Inscripcion inscripcion) {
        System.out.println("No se puede cancelar una inscripción confirmada");
    }
    @Override
    public void ConfirmarInscripcion(Inscripcion inscripcion) {
        System.out.println("La inscripción ya se encuentra confirmada");
    }
}

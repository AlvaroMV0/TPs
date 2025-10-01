package state;

public class Cancelado implements EstadoInscripcion{
    @Override
    public void Cancelar(Inscripcion inscripcion) {
        System.out.println("La inscripcion ya se encuentra Cancelada");
    }
    @Override
    public void ConfirmarInscripcion(Inscripcion inscripcion) {
        System.out.println("No se puede confirmar una inscripción cancelada");
    }
}

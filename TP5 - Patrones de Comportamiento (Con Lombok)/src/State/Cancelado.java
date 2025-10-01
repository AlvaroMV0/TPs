package State;

public class Cancelado implements EstadoInscripcion{
    @Override
    public void cambiarEstado(Inscripcion inscripcion) {
        System.out.println("La inscripción está 'Cancelada'. No se puede cambiar el estado.");
    }
}

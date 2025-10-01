package State;

public class Inscrito implements EstadoInscripcion {
    @Override
    public void cambiarEstado(Inscripcion inscripcion) {
        System.out.println("La inscripción ya se encuentra en estado 'Inscrito'. No se puede cambiar el estado.");
    }
}

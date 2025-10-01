package state;

public class EnEspera implements EstadoInscripcion{
    @Override
    public void Cancelar(Inscripcion inscripcion) {
        System.out.println("Cancelando Inscripción");
        inscripcion.setEstadoInscripcion(new Cancelado());
    }
    @Override
    public void ConfirmarInscripcion(Inscripcion inscripcion) {
        System.out.println("Confirmando Inscripción");
        inscripcion.setEstadoInscripcion(new Inscrito());
    }
}

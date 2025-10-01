package State;

public class EnEspera implements EstadoInscripcion{
    @Override
    public void cambiarEstado(Inscripcion inscripcion) {
        if (inscripcion.getLegajoAlumno().length() <= 4) {
            inscripcion.setEstadoInscripcion(new Inscrito());
            System.out.println("Estado cambiado a: Inscrito.");
        } else {
            inscripcion.setEstadoInscripcion(new Cancelado());
            System.out.println("Estado cambiado a: Cancelado.");
        }
    }
}

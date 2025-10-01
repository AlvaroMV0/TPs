package State;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Inscripcion {

    private String legajoAlumno;
    private EstadoInscripcion estadoInscripcion;

    public Inscripcion(String legajoAlumno) {
        this.legajoAlumno = legajoAlumno;
        this.estadoInscripcion = new EnEspera();
        System.out.println("Nueva inscripción para legajo " + legajoAlumno + ". Estado inicial: En Espera.");
    }

    public void inscribir() {
        this.estadoInscripcion.cambiarEstado(this);
    }
}

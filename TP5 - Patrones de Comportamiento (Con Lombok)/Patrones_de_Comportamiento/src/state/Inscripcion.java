package state;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Inscripcion {
    EstadoInscripcion estadoInscripcion = new EnEspera();
    public void Cancelar(){
        estadoInscripcion.Cancelar(this);
    }
    public void Confirmar(){
        estadoInscripcion.ConfirmarInscripcion(this);
    }
}

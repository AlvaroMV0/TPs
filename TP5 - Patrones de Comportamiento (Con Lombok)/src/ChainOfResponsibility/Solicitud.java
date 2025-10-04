package ChainOfResponsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Solicitud {
    private int nivelDeDificultad;
    private String nombreSolicitud;
    private String detalleSolicitud;
}

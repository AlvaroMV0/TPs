package ChainOfResponsibility;

import java.util.Objects;

public class Asistente implements Handler {
    private Handler next;


    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Solicitud s) {
        Objects.requireNonNull(s,"La solicitud no puede ser nula");
        if (s.getNivelDeDificultad() == 1){
            System.out.println("La solicitud de \""+ s.getNombreSolicitud().trim() + "\" fue solucionada, por el asistente.");
        }
        else {
            if (this.next != null) {
                this.next.handle(s);
            } else {
                System.out.println("Nadie pudo manejar la solicitud : \""+ s.getNombreSolicitud().trim() + "\".");
            }
        }
    }

}

package memento;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class Examen {
    private String contenido = "";

    public void escribir (String texto) {
        contenido += texto;
    }

    public Memento save() {
        return new Memento(this.contenido);
    }

    public void restore(Memento m) {
        contenido = m.getEstado();
    }
}

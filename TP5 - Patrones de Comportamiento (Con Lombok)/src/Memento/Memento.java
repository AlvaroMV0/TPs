package Memento;

import java.util.List;

public class Memento {
    private final List<String> estado;

    public Memento(List<String> estado) {
        this.estado = estado;
    }

    public List<String> getEstado() {
        return estado;
    }
}

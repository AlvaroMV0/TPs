package memento;

import lombok.NoArgsConstructor;

import java.util.Stack;

@NoArgsConstructor

public class Historial {
    private Stack<Memento> historial = new Stack();

    public void save(Memento m) {
        historial.push(m);
    }

    public Memento restore(){
        return historial.isEmpty() ? null : historial.pop();
    }
}

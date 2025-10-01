package Memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Examen {
    private List<String> respuestas = new ArrayList<String>();

    public void responderPregunta(String s){
        Objects.requireNonNull(s,"La respuesta no puede ser nula");
        if(s.length()!=1){
            System.out.println("La respuesta solo puede ser a,b,c o d");
        } else {
            respuestas.add(s);
        }
    }

    public List<String> getRespuestas() {
        return respuestas;
    }

    public Memento save(){
        // Se crea una NUEVA lista, si no estaríamos pasando la referencia a memoria
        return new Memento(new ArrayList<>(this.respuestas));
    }

    public void restore (Memento m) {
        // Se crea una NUEVA lista, si no estaríamos pasando la referencia a memoria
        this.respuestas = new ArrayList<>(m.getEstado());
    }
}

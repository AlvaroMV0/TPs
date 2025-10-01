package observer;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

public class Curso {
    private List<Observer> observers = new ArrayList<>();
    private String aviso;
    private LocalDateTime horario;

    public void addObservers(Observer observer){
        observers.add(observer);
    }

    public void setAviso(String aviso){
        this.aviso = aviso;
        notifyObservers(aviso);
    }


    public void setHorario(LocalDateTime horario){
        this.horario = horario;
        notifyObservers(horario);
    }

    private void notifyObservers(Object cambio){
        for (Observer o: observers){
            o.Update(cambio);
        }
    }
}

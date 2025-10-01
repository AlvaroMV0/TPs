package Observer;

import java.util.ArrayList;
import java.util.List;

class Curso implements Subject{
    private List<Observer> observadores = new ArrayList<>();
    private String nombre;

    public  Curso(String n){
        this.nombre = n;
    }
    @Override
    public void addObserver(Observer o){
        observadores.add(o);
    }
    @Override
    public void removeObserver(Observer o){
        observadores.remove(o);
    }
    @Override
    public void notifyObservers(String mensaje){
        System.out.println("\n[Aviso de "+nombre+"]: Notificando a observadores...");
        for (Observer o: observadores){
            o.update(mensaje);
        }
    }
    // Método de cambio de estado que activa la notificación
    public void cambiarHorario(String nuevoHorario) {
        String mensaje = "Cambio de horario: " + nuevoHorario;
        notifyObservers(mensaje);
    }

    public void publicarAviso(String aviso) {
        String mensaje = "Nuevo aviso: " + aviso;
        notifyObservers(mensaje);
    }
}



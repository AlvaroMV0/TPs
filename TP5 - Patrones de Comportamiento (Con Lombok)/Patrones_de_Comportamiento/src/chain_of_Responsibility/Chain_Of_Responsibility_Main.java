package chain_of_Responsibility;

public class Chain_Of_Responsibility_Main {
    public static void main(String[] args){

        Asistente asistente = new Asistente();
        Profesor profesor = new Profesor();
        Coordinador coordinador = new Coordinador();

        asistente.setSiguiente(profesor);
        profesor.setSiguiente(coordinador);

        asistente.manejar("Problema nivel 4",4);
        asistente.manejar("Problema nivel 2",2);
        asistente.manejar("Problema nivel 1",1);
        asistente.manejar("Problema nivel 0",0);

    }
}

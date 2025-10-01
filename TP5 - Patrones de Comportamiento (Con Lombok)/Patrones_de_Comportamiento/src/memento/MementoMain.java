package memento;

public class MementoMain {
    public static void main(String[] args){
        Examen examen = new Examen();
        Historial historial = new Historial();

        examen.escribir("Hola Mundo");
        historial.save(examen.save());

        examen.escribir(" :D");
        historial.save(examen.save());

        System.out.println("Content: "+examen.getContenido());

        examen.restore(historial.restore());
        System.out.println("Undo 1: "+examen.getContenido());

        examen.restore(historial.restore());
        System.out.println("Undo 2: "+examen.getContenido());

    }
}

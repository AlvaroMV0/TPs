package state;

public class StateMain {
    public static void main(String[] args){
        Inscripcion inscripcion1 = new Inscripcion();
        Inscripcion inscripcion2 = new Inscripcion();

        inscripcion1.Confirmar();
        inscripcion2.Cancelar();

        inscripcion1.Cancelar();
        inscripcion1.Confirmar();
        inscripcion2.Confirmar();
        inscripcion2.Cancelar();
    }
}

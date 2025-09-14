package composite;

//Clase hoja: Plato
public class Plato implements ElementoMenu{
    private String nombre;

    public Plato(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrar(String indent) {
        System.out.println(indent + " - Plato: " + nombre);
    }
}

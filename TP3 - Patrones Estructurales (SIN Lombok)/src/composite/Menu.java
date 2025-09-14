package composite;

//Clase compuesta: Menu
import java.util.ArrayList;
import java.util.List;

public class Menu implements ElementoMenu{
    private String nombre;
    private List<ElementoMenu> elementos = new ArrayList<>();

    public Menu(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ElementoMenu elemento) {
        elementos.add(elemento);
    }

    @Override
    public void mostrar(String indent) {
        System.out.println(indent + "+ Menú: " + nombre);
        for (ElementoMenu em : elementos) {
            em.mostrar(indent );
        }
    }
}

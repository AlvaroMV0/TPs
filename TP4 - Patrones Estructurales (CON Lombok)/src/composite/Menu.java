package composite;

//Clase compuesta: Menu

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Menu implements ElementoMenu {
    private final String nombre;
    private final List<ElementoMenu> elementos = new ArrayList<>();


    public void agregar(ElementoMenu elemento) {
        elementos.add(elemento);
    }

    @Override
    public void mostrar(String indent) {
        System.out.println(indent + "+ Menú: " + nombre);
        for (ElementoMenu em : elementos) {
            em.mostrar(indent + " ");
        }
    }
}

package composite;

//Clase hoja: Plato

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Plato implements ElementoMenu {
    private final String nombre;


    @Override
    public void mostrar(String indent) {
        System.out.println(indent + " - Plato: " + nombre);
    }
}

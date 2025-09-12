package main.singleton;

import main.factory.Libro;

import java.util.ArrayList;
import java.util.List;


public enum Database {
    INSTANCE;
    private final List<Libro> listaLibros = new ArrayList<>();


    public void agregarLibro(Libro libro) {
        // Itera la base de datos para evitar generar duplicados
        for (Libro libroAComparar : listaLibros) {
            if (libro.equals(libroAComparar)){
                System.out.println("ERROR: El libro \"" + libroAComparar.mostrarInfo() + "\" ya existe en la biblioteca.");
                return;
            }
        }
        System.out.println("ÉXITO: Agregado " + libro.mostrarInfo());
        listaLibros.add(libro);
    }


    public void listarLibros() {
        System.out.println("La lista de libros hasta el momento está conformada por: ");
        int i = 1;
        // Itera por toda la array de la database, incluyendo un número al principio como índice
        for (Libro libro : listaLibros) {
            System.out.println(i + ". " + libro.mostrarInfo()+".");
            i++;
        }
        System.out.println("Total de libros: " + listaLibros.size());
    }

    public Libro getLibro(int index) {
        // Validación para evitar errores.
        if (index >= 0 && index < listaLibros.size()) {
            return listaLibros.get(index);
        }
        // Devuelve null si no se encuentra el libro.
        return null;
    }
}

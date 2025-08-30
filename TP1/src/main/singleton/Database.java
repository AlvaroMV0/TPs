package main.singleton;

import main.factory.Libro;

import java.util.ArrayList;
import java.util.List;



public enum Database
{
    INSTANCE;
    private final List<Libro> listaLibros = new ArrayList<>();



    public void agregarLibro(Libro libro)
    {
        listaLibros.add(libro);
    }


    public void listarLibros()
    {
        System.out.println("La lista de libros hasta el momento está conformada por: ");
        int i = 0;
        for (Libro libro : listaLibros)
        {
            System.out.println(i + ". "+ libro.mostrarInfo());
            i++;
        }
        System.out.println("Total de libros: " + listaLibros.size());
    }
}

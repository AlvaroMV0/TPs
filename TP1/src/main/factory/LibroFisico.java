package main.factory;

import java.util.Objects;

public class LibroFisico implements Libro
{
    private final String nombre;
    @Override
    public void imprimir()
    {
        System.out.println("\""+nombre+"\" "+ "Libro Físico");
    }

    public LibroFisico(String nombre){
        this.nombre = nombre;
    }


}

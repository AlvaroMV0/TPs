package main.factory;

import lombok.AllArgsConstructor;


@AllArgsConstructor

public class LibroDigital implements Libro
{
    private String titulo,autor;
    private int paginas;

    @Override
    public String mostrarInfo()
    {
        return ("Libro digital: \"" + titulo + "\" por " + autor );
    }

    @Override
    public Libro clone() throws CloneNotSupportedException
    {
        return (Libro) super.clone();
    }



}

package main.factory;

import lombok.AllArgsConstructor;


@AllArgsConstructor

public class LibroFisico implements Libro
{

    private String titulo,autor;
    private int paginas;

    @Override
    public String mostrarInfo()
    {
        return ("Libro físico: \"" + titulo + "\" por " + autor );
    }

    @Override
    public Libro clone() throws CloneNotSupportedException
    {
        return (Libro) super.clone();
    }


}

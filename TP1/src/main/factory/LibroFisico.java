package main.factory;

public class LibroFisico implements Libro
{
    public String nombre;
    @Override
    public void imprimir()
    {
        System.out.println( "\""+nombre+"\" "+ "Libro Físico");
    }

    public LibroFisico(String nombre){
        this.nombre = nombre;
    }
}

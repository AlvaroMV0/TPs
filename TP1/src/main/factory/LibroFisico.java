package main.factory;

public class LibroFisico extends Libro
{
    @Override
    public void imprimir()
    {
        System.out.println("Libro Fïsico");
    }

    public LibroFisico(String nombre){
        this.nombre = nombre;
    }
}

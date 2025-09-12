package main.factory;

public class LogisticaLibroFisico extends LogisticaLibro
{

    @Override
    public Libro crearLibro(String nombre,String autor, int numPaginas)
    {
        return new LibroFisico(nombre, autor, numPaginas);
    }
}

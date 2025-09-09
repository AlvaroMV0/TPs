package main.factory;

public class LogisticaLibroDigital extends LogisticaLibro
{
    @Override
    public Libro crearLibro(String nombre, String autor, int numPaginas)
    {
        return new LibroDigital(nombre,autor,numPaginas);
    }
}

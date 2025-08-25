package main.factory;

public class LogisticaLibro
{
    public static Libro crearLibro(String tipo, String nombre)
    {
        return switch (tipo.toLowerCase())
        {
            case "digital" -> new LibroDigital(nombre);
            case "fisico" -> new LibroFisico(nombre);
            default -> throw new IllegalArgumentException("Tipo desconocido");
        };
    }
}

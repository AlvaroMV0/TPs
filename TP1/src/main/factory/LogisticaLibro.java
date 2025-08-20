package main.factory;

public class LogisticaLibro
{
    public static Libro crearLibro(String tipo, String nombre)
    {
        return switch (tipo)
        {
            case "Digital" -> new LibroDigital(nombre);
            case "Fisico" -> new LibroFisico(nombre);
            default -> throw new IllegalArgumentException("Tipo desconocido");
        };
    }
}

package main.factory;


import java.util.Objects;

public class LibroFisico implements Libro {

    private final String titulo;
    private final String autor;
    private final int paginas;

    public LibroFisico(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    @Override
    public String mostrarInfo() {
        return ("Libro físico: \"" + titulo + "\" por " + autor + "\" (" + paginas +" páginas)");
    }

    @Override
    public Libro clone() throws CloneNotSupportedException {
        return (Libro) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LibroFisico that)) return false;
        return ((paginas == that.paginas) && Objects.equals(titulo, that.titulo) && Objects.equals(autor, that.autor));
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, paginas);
    }

}

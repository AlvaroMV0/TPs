package main.factory;

public class LibroDigital implements Libro
{
    private final String nombre;

    @Override
    public void imprimir(){
        System.out.println( "\""+nombre+"\" "+ "Libro Digital");
    }
    public LibroDigital(String nombre){
        this.nombre = nombre;
    }

}

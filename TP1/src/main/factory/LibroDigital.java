package main.factory;

public class LibroDigital extends Libro
{
    @Override
    public void imprimir(){
        System.out.println("Libro Digital");
    }
    public LibroDigital(String nombre){
        this.nombre = nombre;
    }
}

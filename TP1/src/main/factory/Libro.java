package main.factory;


public interface Libro extends Cloneable
{
    String mostrarInfo();
    public Libro clone() throws CloneNotSupportedException;
}

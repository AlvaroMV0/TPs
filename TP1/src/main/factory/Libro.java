package main.factory;


public interface Libro extends Cloneable {
    String mostrarInfo();

    Libro clone() throws CloneNotSupportedException;
}

package main.singleton;

import main.factory.Libro;
import main.factory.LogisticaLibro;

import java.util.ArrayList;

public class Database
{
    public static ArrayList<Libro> listaLibros;
    //Con volatile para el Double-Checked Locking
    private static volatile Database instance;
    private Database()
    {
        this.listaLibros = new ArrayList<Libro>();
    }
    //TODO decidir si crear el libro en el momento de agregarlo o por separado
    public static void agregarLibro(String nombreLibro, String tipoLibro)
    {
        listaLibros.add(LogisticaLibro.crearLibro(tipoLibro,nombreLibro));
    }
    public static void listarLibros()
    {
        System.out.println("La lista de libros hasta el momento está conformada por: ");
        for (int i = 0; i < listaLibros.size() ; i++)
        {
            System.out.println(i+ ". "+ listaLibros.get(i));
        }
        System.out.println("Total de libros: "+ listaLibros.size());
    }

    // -- SINGLETON --
    //Implementación del Singleton para Database
    //Con Double-Checked Locking para resolver concurrencia
    public static Database getInstance()
    {
        if (instance ==null) // Primera verificación Sin Lock
        {
            synchronized (Database.class)
            {
                if (instance == null) //Segunda verificación
                {
                    instance = new Database();
                }
            }
        }
        return instance;
    }
}

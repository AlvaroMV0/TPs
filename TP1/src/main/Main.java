package main;

import main.singleton.Database;

import javax.xml.crypto.Data;

public class Main
{
    public static void main (String[] args)
    {
        //Creación de la DataBase
        Database.getInstance();
        //Creación y agregación de libros
        Database.agregarLibro("Harry Potter","Fisico");
        Database.agregarLibro("Percy Jackson","Fisico");
        Database.agregarLibro("Thomas y sus amigos","Digital");
        //Impresión de libros
        Database.listarLibros();
    }
}

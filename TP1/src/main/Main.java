package main;

import main.builder.Usuario;
import main.singleton.Database;

import javax.xml.crypto.Data;

public class Main
{
    public static void main (String[] args)
    {
        //TODO Implementar lógica de usuario/admin y la creación de AdminUI,UsuarioUI, y los envios
        //TODO Agregar private a las variables de las clases


        //Creación de la DataBase
        Database db = Database.getInstance();

        //Creación y agregación de libros
        db.agregarLibro("Harry Potter","Fisico");
        db.agregarLibro("Percy Jackson","Fisico");
        db.agregarLibro("Thomas y sus amigos","Digital");

        //Impresión de libros
        db.listarLibros();

        Usuario usuario1 = new Usuario.Builder()
                .nombre("Fran")
                .email("francisco123@gmail.com")
                .build();
        Usuario usuario2 = new Usuario.Builder()
                .nombre("Jennifer")
                .email("Jennifer123@gmail.com")
                .build();

        System.out.println(usuario1);
        System.out.println(usuario2);

        //Para comprobar que realmente son disntitos objetos basta con la
        //diferencia de nombres o debemos agregar algo como el object ID?
    }
}

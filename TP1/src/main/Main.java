package main;

import main.abstractfactory.AdminFactory;
import main.abstractfactory.Cliente;
import main.abstractfactory.UsuarioFactory;
import main.builder.Usuario;
import main.factory.Libro;
import main.factory.LogisticaLibroDigital;
import main.factory.LogisticaLibroFisico;
import main.singleton.Database;

public class Main
{
    public static void main(String[] args)
    {

        System.out.println("\n\n\n");

        LogisticaLibroDigital fabricaDigital = new LogisticaLibroDigital();
        LogisticaLibroFisico fabricaFisica = new LogisticaLibroFisico();


        Libro libro1 = fabricaDigital.crearLibro("Harry Potter", "JK Rowling", 300);


        System.out.println("------------- Database -------------");

        //Creación de la DataBase
        Database db = Database.INSTANCE;

        //Creación y agregación de libros
        //Libros digitales
        db.agregarLibro(libro1);
        db.agregarLibro(fabricaDigital.crearLibro("Percy Jackson", "Rick Riordan", 300));
        //Libros Físicos
        db.agregarLibro(fabricaFisica.crearLibro("El Aleph", "Jorge Luis Borges", 150));
        db.agregarLibro(fabricaFisica.crearLibro("El Señor de los Anillos", "J.R.R. Tolkien", 1200));
        db.agregarLibro(fabricaFisica.crearLibro("Dune", "Frank Herbert", 688));


        //Impresión de libros
        db.listarLibros();
        System.out.println("------------------------------------\n\n");


        System.out.println("------------- Cliente -------------");
        // Cliente administrador
        Cliente admin = new Cliente(new AdminFactory(), "Oscuro");
        admin.usarSistema(libro1);

        // Cliente usuario normal
        Cliente usuario = new Cliente(new UsuarioFactory(), "Claro");
        usuario.usarSistema(libro1);


        System.out.println("-----------------------------------\n\n");


        System.out.println("------------- Usuario -------------");
        //Impresión de Usuarios

        Usuario usuario1 = Usuario.builder()
                .nombre("Fran")
                .email("francisco123@gmail.com")
                .build();
        Usuario usuario2 = Usuario.builder()
                .nombre("Jennifer")
                .email("Jennifer123@gmail.com")
                .build();

        System.out.println(usuario1);
        System.out.println(usuario2);

        System.out.println("-----------------------------------\n\n");


    }
}

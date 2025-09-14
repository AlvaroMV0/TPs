package main;

import main.abstractfactory.AdminFactory;
import main.abstractfactory.Cliente;
import main.abstractfactory.UsuarioFactory;
import main.builder.Usuario;
import main.factory.Libro;
import main.factory.LogisticaLibroDigital;
import main.factory.LogisticaLibroFisico;
import main.prototype.Prestamo;
import main.singleton.Database;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {






        // --- Demostración de Factory Method y Singleton ---
        System.out.println("\n\n------------- Factory Method y Singleton -------------");
        Database db = Database.INSTANCE; // Se obtiene la instancia única de la base de datos (Singleton).
        LogisticaLibroDigital fabricaDigital = new LogisticaLibroDigital(); // Fábrica de libros digitales.
        LogisticaLibroFisico fabricaFisica = new LogisticaLibroFisico(); // Fábrica de libros físicos.

        // Se crean y agregan libros a la base de datos usando las fábricas (Factory Method).
        db.agregarLibro(fabricaDigital.crearLibro("Harry Potter", "JK Rowling", 300));
        db.agregarLibro(fabricaDigital.crearLibro("Percy Jackson", "Rick Riordan", 288));
        db.agregarLibro(fabricaFisica.crearLibro("El Aleph", "Jorge Luis Borges", 150));
        db.listarLibros();







        // --- Demostración de Abstract Factory ---
        System.out.println("\n\n------------- Abstract Factory -------------");
        Libro libroParaCliente = db.getLibro(0); // Se obtiene un libro para usar en el ejemplo.

        // Se crea un cliente administrador usando la fábrica de administradores.
        System.out.println("--- Cliente Administrador ---");
        Cliente admin = new Cliente(new AdminFactory(), "Oscuro");
        admin.usarSistema(libroParaCliente);

        // Se crea un cliente normal usando la fábrica de usuarios.
        System.out.println("\n--- Cliente Usuario ---");
        Cliente usuario = new Cliente(new UsuarioFactory(), "Claro");
        usuario.usarSistema(libroParaCliente);






        // --- Demostración de Builder ---
        System.out.println("\n\n------------- Builder -------------");

        // Se construyen objetos Usuario complejos de forma fluida (Builder).
        Usuario usuario1 = Usuario.builder()
                .nombre("Francisco")
                .email("fran@mail.com")
                .domicilio("Calle Falsa 123")
                .build();

        Usuario usuario2 = Usuario.builder()
                .nombre("Jennifer")
                .email("jen@mail.com")
                .build();

        System.out.println("Usuario 1: " + usuario1);
        System.out.println("Usuario 2: " + usuario2);






        // --- Demostración de Prototype ---
        System.out.println("\n\n------------- Prototype --------------");


        Prestamo prestamoOriginal = new Prestamo(libroParaCliente, usuario1, "2025-09-08", "2025-09-22");


        Prestamo prestamoShallow = prestamoOriginal.clone();      // Clonación superficial
        Prestamo prestamoDeep = prestamoOriginal.deepClone();     // Clonación profunda

        System.out.println("--- ESTADO INICIAL ---");
        System.out.println("Original: " + prestamoOriginal);
        System.out.println("Shallow:  " + prestamoShallow);
        System.out.println("Deep:     " + prestamoDeep + "\n");


        System.out.println("--- ACCIÓN: Creando un nuevo usuario 'Francisco Modificado' usando toBuilder() ---\n");

        Usuario usuarioModificado = prestamoOriginal.getUsuario().toBuilder()
                .nombre("Francisco Modificado")
                .build();


        prestamoOriginal.setUsuario(usuarioModificado);



        System.out.println("--- ESTADO FINAL ---");
        System.out.println("Original: " + prestamoOriginal);
        System.out.println("Shallow:  " + prestamoShallow + " <-- ¡NO CAMBIÓ! Sigue apuntando al objeto Usuario original e inmutable.");
        System.out.println("Deep:     " + prestamoDeep + " <-- TAMPOCO CAMBIÓ. Tiene su propia copia del objeto Usuario original.");



    }
}
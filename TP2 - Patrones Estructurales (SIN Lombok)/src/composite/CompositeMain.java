package composite;


public class CompositeMain {
    public static void main(String[] args) {
        System.out.println("\n\n- - - - - Patrón Composite - - - - -\n");

        //Platos
        ElementoMenu plato1 = new Plato("Hamburguesa con papas fritas");
        ElementoMenu plato2 = new Plato("Helado napolitano");
        ElementoMenu plato3 = new Plato("Frutillas con crema");
        ElementoMenu plato4 = new Plato("Milanesa de pollo con puré de papa");
        ElementoMenu plato5 = new Plato("Ravioles de verdura");

        // Menú
        Menu postre = new Menu("Postres");
        postre.agregar(plato2);
        postre.agregar(plato3);

        Menu menuDia = new Menu("Menú del día");
        menuDia.agregar(plato1);
        menuDia.agregar(plato4);
        menuDia.agregar(plato5);
        menuDia.agregar(postre); //Un menú dentro de otro (el Menú de Postres dentro del Menú del Día)

        // Mostramos el menú
        menuDia.mostrar("");


    }
}

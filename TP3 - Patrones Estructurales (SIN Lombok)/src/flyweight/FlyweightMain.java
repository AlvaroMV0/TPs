package flyweight;

public class FlyweightMain {
    public static void main(String[] args) {

        System.out.println("\n\n- - - - - Patrón Flyweight - - - - -\n");

        FabricaArbol fabrica = new FabricaArbol();
        for (int i = 0; i < 250000; i++) {
            Arbol arbol = fabrica.obtenerInfo("Nogal", "suave", "marron oscuro");
            if( i > (250000-3) || i<3 ) arbol.posicion(i, 0);
        }
        for (int i = 0; i < 250000; i++) {
            Arbol arbol = fabrica.obtenerInfo("Roble", "porosa", "marron");
            if( i > (250000-3) || i<3 ) arbol.posicion(i, 1);
        }
        for (int i = 0; i < 250000; i++) {
            Arbol arbol = fabrica.obtenerInfo("Acre", "uniforme", "blanco");
            if( i > (250000-3) || i<3 )  arbol.posicion(i, 2);
        }
        for (int i = 0; i < 250000; i++) {
            Arbol arbol = fabrica.obtenerInfo("Castaño", "irregular", "marron claro");
            if( i > (250000-3) || i<3 ) arbol.posicion(i, 3);
        }
    }
}

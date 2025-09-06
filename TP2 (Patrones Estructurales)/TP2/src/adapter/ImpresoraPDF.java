package adapter;

/*
    Declaro el metodo "imprimir" como static para no tener que crear instancias de esta clase para
    llamar a un metodo que solo imprime en pantalla y no tiene atributos propios
*/

public class ImpresoraPDF {
    public static void imprimir(String documento){
        System.out.println("Imprimiendo " + documento + ".pdf");
    }
}

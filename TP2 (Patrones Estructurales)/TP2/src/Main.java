import adapter.ImpresoraAdapter;

public class Main {
    public static void main(String[] args) {

        ImpresoraAdapter impresora = new ImpresoraAdapter();

        impresora.imprimir("Acta de nacimiento", "PDF");
        impresora.imprimir("Ceritificado de regularidad", "texto");
    }
}
package adapter;

public class AdapterMain {
    public static void main(String[] args) {
        System.out.println("\n\n- - - - - Patrón adapter - - - - -\n");

        ImpresoraDocumento impresora = new ImpresoraDocumento();
        impresora.imprimir("pdf", "doc1");   //Formato normal
        impresora.imprimir("txt", "doc2");   //Formato soportado por adaptador
        impresora.imprimir("docx", "doc3");  //Formato no soportado
    }
}

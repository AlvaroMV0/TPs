package adapter;

public class ImpresoraDocumento implements Impresora {
    private ImpresoraAdapter impresoraAdapter;
    @Override
    public void imprimir(String documento, String tipoDocumento){
        if (tipoDocumento.equalsIgnoreCase("pdf")){
            System.out.println("Imprimiendo archivo PDF: " + documento);
        } else {
            impresoraAdapter = new ImpresoraAdapter();
            impresoraAdapter.imprimir(documento,tipoDocumento);
        }
    }
}

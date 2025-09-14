package adapter;

public class ImpresoraDocumento implements Impresora {
    private ImpresoraAdapter impresoraAdapter = null;

    @Override
    public void imprimir(String tipoDocumento, String documento) {
        // Se comprueba el formato del documento y en caso de no ser pdf se llama al adaptador para verificar
        // si este formato esta incluido
        if (tipoDocumento.equalsIgnoreCase("pdf")) {
            ImpresoraPDF.imprimir(documento);
        } else {
            impresoraAdapter = new ImpresoraAdapter();
            impresoraAdapter.imprimir(tipoDocumento, documento);
        }
    }
}

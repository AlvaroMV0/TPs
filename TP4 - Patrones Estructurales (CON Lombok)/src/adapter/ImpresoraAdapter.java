package adapter;

public class ImpresoraAdapter implements Impresora {

    @Override
    public void imprimir(String tipoDocumento, String documento) {
        // El unico formato soportado por este adaptador es txt, en caso de que entre un formato que no sea txt saldra un mensaje de error
        if (tipoDocumento.equalsIgnoreCase("txt")) {
            ImpresoraTexto.imprimir(documento);
        } else {
            System.out.println("Error: Formato '" + tipoDocumento + "' no soportado");
        }
    }
}

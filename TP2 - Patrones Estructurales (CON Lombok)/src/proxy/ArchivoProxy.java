package proxy;
//El proxy controla el acceso al objeto original "ArchivoReal"
public class ArchivoProxy implements Archivo{
    private ArchivoReal archivoReal;
    private String nombreArchivo;
    private String rolUsuario;

    public ArchivoProxy(String nombreArchivo, String rolUsuario){
        this.nombreArchivo = nombreArchivo;
        this.rolUsuario = rolUsuario;
    }
    // Revisa que el rol del usuario sea ADMIN sino se rechaza el acceso
    private boolean tienePermiso(){
        return "ADMIN".equalsIgnoreCase(rolUsuario);
    }
    @Override
    public void leer(){
        if(tienePermiso()){
            if(archivoReal == null){
                archivoReal = new ArchivoReal(nombreArchivo);
            }
            archivoReal.leer();
        } else {
            System.out.println("Acceso denegado. El rol '" + rolUsuario + "' no tiene permisos para leer " + nombreArchivo);
        }
    }

}

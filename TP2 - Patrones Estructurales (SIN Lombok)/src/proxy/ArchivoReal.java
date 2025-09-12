package proxy;
// ArchivoReal es un objeto real que realiza el trabajo pesado.
// En este caso,
// leer el archivo del que no queremos que tengan acceso directo
class ArchivoReal implements Archivo{
    private String nombreArchivo;
    public ArchivoReal(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
        cargarDesdeDisco();
    }
    //simulamos una operación costosa, como cargar un archivo pesado
    private void cargarDesdeDisco(){
        System.out.println("Cargando archivo pesado: " + nombreArchivo);
    }
    @Override
    public void leer(){
        System.out.println("Leyendo contenido del archivo: " + nombreArchivo);
    }
}

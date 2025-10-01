package Command;

public class AlumnoInvoker {
    private Command comando;
    public void setComando(Command comando){
        this.comando =comando;
    }
    public void enviarSolicitud(){comando.execute();}
}

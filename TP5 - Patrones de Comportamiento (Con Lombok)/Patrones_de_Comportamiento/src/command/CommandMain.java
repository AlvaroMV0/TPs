package command;

public class CommandMain {
    public static void main(String[] args){
        Invoker invoker = new Invoker(new InscribirseCursoCommand());
        invoker.execute();
        invoker.setCommandInterface(new AbandonarCursoCommand());
        invoker.execute();
        invoker.setCommandInterface(new SolicitarCertificadoCommand());
        invoker.execute();
    }
}

package Command;

public class SolicitarCertificadoCommand implements Command {
    private Plataforma plataforma;
    private  String curso;
    public SolicitarCertificadoCommand(Plataforma p, String c){
        this.plataforma = p;
        this.curso = c;
    }
    @Override
    public void execute(){plataforma.solicitarCertificado(curso);
    }
}

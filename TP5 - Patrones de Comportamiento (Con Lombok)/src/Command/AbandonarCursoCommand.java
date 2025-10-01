package Command;

public class AbandonarCursoCommand implements Command{
    private Plataforma plataforma;
    private String curso;
    public AbandonarCursoCommand(Plataforma p, String c){
        this.plataforma = p;
        this.curso = c;
    }
    @Override
    public void execute(){plataforma.abandonar(curso);}
}

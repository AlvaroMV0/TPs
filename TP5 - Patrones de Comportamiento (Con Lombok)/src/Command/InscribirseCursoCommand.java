package Command;

class InscribirseCursoCommand implements Command{
    private Plataforma plataforma;
    private String curso;
    public InscribirseCursoCommand(Plataforma p, String c){
        this.plataforma = p;
        this.curso = c;
    }
    @Override
    public void execute(){plataforma.inscribir(curso);}
}

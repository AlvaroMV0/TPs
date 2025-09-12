package main.abstractfactory;

public class UsuarioUI implements InterfazUI {
    private final String tema;

    public UsuarioUI(String tema) {
        this.tema = tema;
    }

    @Override
    public void mostrarUI() {
        System.out.println("Mostrando UI de usuario con el tema " + tema);
    }
}

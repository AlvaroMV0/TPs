package main.abstractfactory;

public class AdminUI implements InterfazUI {
    private final String tema;

    public AdminUI(String tema) {
        this.tema = tema;
    }

    @Override
    public void mostrarUI() {
        System.out.println("Mostrando UI de Admin con el tema " + tema);
    }
}

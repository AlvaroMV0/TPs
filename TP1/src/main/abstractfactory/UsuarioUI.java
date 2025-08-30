package main.abstractfactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class UsuarioUI implements InterfazUI
{
    private String tema;
    @Override
    public void mostrarUI()
    {
        System.out.println("Mostrando UI de usuario con el tema " + tema);
    }
}

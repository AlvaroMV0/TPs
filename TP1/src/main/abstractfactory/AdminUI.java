package main.abstractfactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class AdminUI implements InterfazUI
{
    private String tema;

    @Override
    public void mostrarUI()
    {
        System.out.println("Mostrando UI de Admin con el tema "+ tema);
    }
}

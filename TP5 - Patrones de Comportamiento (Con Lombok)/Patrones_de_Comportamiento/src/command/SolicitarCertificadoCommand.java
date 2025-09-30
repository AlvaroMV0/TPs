package command;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class SolicitarCertificadoCommand implements CommandInterface{
    @Override
    public void execute() {
        System.out.println("Mostrar Certificado Alumno");
    }
}

package template_Method;

import lombok.experimental.SuperBuilder;

@SuperBuilder

public class ReporteCurso extends ReporteAcademico{
    private String tipoCurso;
    @Override
    protected void personalizarContenido() {
        if (tipoCurso=="Online"){
            System.out.println("Personalizando contenido para curso "+tipoCurso);
        } else if (tipoCurso=="Presencial"){
            System.out.println("Personalizando contenido para curso "+tipoCurso);
        } else {
            System.out.println("Personalizando contenido para curso Hibrido");
        }
    }
}

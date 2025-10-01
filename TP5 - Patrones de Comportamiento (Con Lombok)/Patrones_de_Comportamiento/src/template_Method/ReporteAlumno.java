package template_Method;

import lombok.experimental.SuperBuilder;

@SuperBuilder

public class ReporteAlumno extends ReporteAcademico {
    @Override
    protected void personalizarContenido() {
        System.out.println("Personalizando contenido para alumno");
    }
}

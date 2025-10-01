package template_Method;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

@SuperBuilder

abstract class ReporteAcademico {

    public final void escribirReporte(){
        generarEncabezado();
        generarContenido();
        personalizarContenido();
        generarPie();
    }
    protected void generarEncabezado(){
        System.out.println("Generando Encabezado");
    }
    protected void generarPie(){
        System.out.println("Generando Pie");
    }
    protected void generarContenido(){
        System.out.println("Generando Contenido");
    }
    protected void personalizarContenido(){};
}

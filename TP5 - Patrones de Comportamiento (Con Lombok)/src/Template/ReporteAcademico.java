package Template;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.atomic.AtomicLong;

public abstract class ReporteAcademico {
    private final static AtomicLong idCounter = new AtomicLong(0);
    private long numeroReporte;
    private ZonedDateTime fechaReporte;



    public final void generarReporte() {
        generarNumeroReporte();
        registrarFechaYHoraLocal();
        buscarEnBd();
        System.out.println("Reporte #" + numeroReporte + " generado en fecha: " + fechaReporte.toLocalDate());
        System.out.println("------------------------------------");
    }



    void registrarFechaYHoraLocal() {
        this.fechaReporte = ZonedDateTime.now(ZoneId.of("America/Argentina/Mendoza"));
    }


    void generarNumeroReporte(){
        this.numeroReporte =  idCounter.getAndIncrement();
    }

    protected abstract void buscarEnBd();

}

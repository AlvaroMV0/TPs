package org.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();
        try {

            // Ejercicio 1: Listar todos los clientes
            System.out.println("\n--- Ejercicio 1: Listar todos los clientes ---");
            String jpql1 = "SELECT c FROM Cliente c";
            TypedQuery<Cliente> query1 = em.createQuery(jpql1, Cliente.class);
            List<Cliente> clientes = query1.getResultList();

            for (Cliente c : clientes) {
                System.out.println("Cliente ID: " + c.getId() + ", Razón Social: " + c.getRazonSocial());
            }

            // Ejercicio 2: Listar todas las facturas generadas en el último mes
            System.out.println("\n--- Ejercicio 2: Listar facturas del último mes ---");

            Calendar cal2 = Calendar.getInstance();
            cal2.add(Calendar.MONTH, -1);
            Date fechaInicioMes = cal2.getTime();

            String jpql2 = "SELECT f FROM Factura f WHERE f.fechaAlta >= :fechaInicioMes";
            TypedQuery<Factura> query2 = em.createQuery(jpql2, Factura.class);
            query2.setParameter("fechaInicioMes", fechaInicioMes);
            List<Factura> facturasUltimoMes = query2.getResultList();

            for (Factura f : facturasUltimoMes) {
                System.out.println("Factura Nro: " + f.getNroComprobante() + ", Cliente: " + f.getCliente().getRazonSocial() + ", Fecha: " + f.getFechaAlta());
            }

            // Ejercicio 3: Obtener el cliente que ha generado más facturas
            System.out.println("\n--- Ejercicio 3: Cliente con más facturas ---");
            String jpql3 = "SELECT f.cliente, COUNT(f) FROM Factura f GROUP BY f.cliente ORDER BY COUNT(f) DESC";

            TypedQuery<Object[]> query3 = em.createQuery(jpql3, Object[].class);
            query3.setMaxResults(1); // Equivalente a FETCH FIRST 1 ROWS ONLY
            List<Object[]> resultado3 = query3.getResultList();

            if (!resultado3.isEmpty()) {
                Cliente cliente = (Cliente) resultado3.get(0)[0];
                Long cantidad = (Long) resultado3.get(0)[1];
                System.out.println("Cliente TOP: " + cliente.getRazonSocial() + ", Cantidad de Facturas: " + cantidad);
            }


            //Ejercicio 4: Listar los artículos más vendidos
            System.out.println("\n--- Ejercicio 4: Artículos más vendidos ---");
            String jpql4 = "SELECT fd.articulo, SUM(fd.cantidad) AS totalVendido FROM FacturaDetalle fd GROUP BY fd.articulo ORDER BY totalVendido DESC";

            TypedQuery<Object[]> query4 = em.createQuery(jpql4, Object[].class);
            List<Object[]> resultados4 = query4.getResultList();

            for (Object[] resultado : resultados4) {
                Articulo articulo = (Articulo) resultado[0];
                Double totalVendido = (Double) resultado[1];
                System.out.println("Artículo: " + articulo.getDenominacion() + ", Total Vendido: " + totalVendido);
            }

            // Ejercicio 5: Consultar las facturas emitidas en los 3 últimos meses de un cliente

            System.out.println("\n--- Ejercicio 5: Facturas de un cliente en los últimos 3 meses ---");
            Long clienteId5 = 1L;
            Calendar cal5 = Calendar.getInstance();
            cal5.add(Calendar.MONTH, -3);
            Date fechaInicioTresMeses = cal5.getTime();

            String jpql5 = "SELECT f FROM Factura f WHERE f.cliente.id = :clienteId AND f.fechaAlta >= :fechaInicioTresMeses";
            TypedQuery<Factura> query5 = em.createQuery(jpql5, Factura.class);
            query5.setParameter("clienteId", clienteId5);
            query5.setParameter("fechaInicioTresMeses", fechaInicioTresMeses);
            List<Factura> facturasCliente = query5.getResultList();

            for (Factura f : facturasCliente) {
                System.out.println("Factura ID: " + f.getId() + ", Total: " + f.getTotal() + ", Fecha: " + f.getFechaAlta());
            }


            // Ejercicio 6: Calcular el monto total facturado por un cliente
            System.out.println("\n--- Ejercicio 6: Monto total facturado por un cliente ---");
            Long clienteId6 = 1L; // Cliente ID de ejemplo

            String jpql6 = "SELECT SUM(f.total) FROM Factura f WHERE f.cliente.id = :clienteId";
            TypedQuery<Double> query6 = em.createQuery(jpql6, Double.class);
            query6.setParameter("clienteId", clienteId6);
            Double totalFacturado = query6.getSingleResult();

            System.out.println("Cliente ID: " + clienteId6 + ", Monto Total Facturado: " + (totalFacturado != null ? totalFacturado : 0.0));


            // Ejercicio 7: Listar los Artículos vendidos en una factura
            System.out.println("\n--- Ejercicio 7: Artículos vendidos en una factura ---");
            Long facturaId7 = 1L; // Factura ID de ejemplo

            String jpql7 = "SELECT fd.articulo FROM FacturaDetalle fd WHERE fd.factura.id = :facturaId";
            TypedQuery<Articulo> query7 = em.createQuery(jpql7, Articulo.class);
            query7.setParameter("facturaId", facturaId7);
            List<Articulo> articulosVendidos = query7.getResultList();

            for (Articulo a : articulosVendidos) {
                System.out.println("Artículo: " + a.getDenominacion() + ", Código: " + a.getCodigo());
            }


            // Ejercicio 8: Obtener el Artículo más caro vendido en una factura
            System.out.println("\n--- Ejercicio 8: Artículo más caro en una factura ---");
            Long facturaId8 = 1L; // Factura ID de ejemplo

            String jpql8 = "SELECT fd.articulo FROM FacturaDetalle fd WHERE fd.factura.id = :facturaId ORDER BY fd.articulo.precioVenta DESC";
            TypedQuery<Articulo> query8 = em.createQuery(jpql8, Articulo.class);
            query8.setParameter("facturaId", facturaId8);
            query8.setMaxResults(1);

            try {
                Articulo articuloMasCaro = query8.getSingleResult();
                System.out.println("Artículo más caro: " + articuloMasCaro.getDenominacion() + ", Precio Venta: " + articuloMasCaro.getPrecioVenta());
            } catch (Exception e) {
                System.out.println("No se encontró ningún artículo en la factura.");
            }


            // Ejercicio 9: Contar la cantidad total de facturas generadas en el sistema
            System.out.println("\n--- Ejercicio 9: Cantidad total de facturas ---");
            String jpql9 = "SELECT COUNT(f) FROM Factura f";
            TypedQuery<Long> query9 = em.createQuery(jpql9, Long.class);
            Long totalFacturas = query9.getSingleResult();

            System.out.println("Total de Facturas generadas: " + totalFacturas);


            // Ejercicio 10: Listar las facturas cuyo total es mayor a un valor determinado
            System.out.println("\n--- Ejercicio 10: Facturas con total mayor a un valor ---");
            Double valorMinimo = 50.0; // Valor de ejemplo

            String jpql10 = "SELECT f FROM Factura f WHERE f.total > :valorMinimo";
            TypedQuery<Factura> query10 = em.createQuery(jpql10, Factura.class);
            query10.setParameter("valorMinimo", valorMinimo);
            List<Factura> facturasCaras = query10.getResultList();

            for (Factura f : facturasCaras) {
                System.out.println("Factura Nro: " + f.getNroComprobante() + ", Total: " + f.getTotal());
            }


            // Ejercicio 11: Consultar las facturas que contienen un Artículo específico
            System.out.println("\n--- Ejercicio 11: Facturas con un artículo específico ---");
            String nombreArticulo = "Manzana"; // Nombre de ejemplo
            String jpql11 = "SELECT f FROM Factura f JOIN f.detallesFactura fd WHERE fd.articulo.denominacion = :nombreArticulo";
            TypedQuery<Factura> query11 = em.createQuery(jpql11, Factura.class);
            query11.setParameter("nombreArticulo", nombreArticulo);
            List<Factura> facturasConArticulo = query11.getResultList();

            for (Factura f : facturasConArticulo) {
                System.out.println("Factura Nro: " + f.getNroComprobante() + ", Cliente: " + f.getCliente().getRazonSocial());
            }

            // Ejercicio 12: Listar los Artículos filtrando por código parcial
            System.out.println("\n--- Ejercicio 12: Artículos por código parcial ---");
            String codigoParcial = "%1719%";
            String jpql12 = "SELECT a FROM Articulo a WHERE a.codigo LIKE :codigoParcial";
            TypedQuery<Articulo> query12 = em.createQuery(jpql12, Articulo.class);
            query12.setParameter("codigoParcial", codigoParcial);
            List<Articulo> articulosPorCodigo = query12.getResultList();

            for (Articulo a : articulosPorCodigo) {
                System.out.println("Artículo: " + a.getDenominacion() + ", Código: " + a.getCodigo());
            }

            // Ejercicio 13: Listar todos los Artículos cuyo precio sea mayor que el promedio
            System.out.println("\n--- Ejercicio 13: Artículos con precio mayor al promedio ---");
            String jpql13 = "SELECT a FROM Articulo a WHERE a.precioVenta > (SELECT AVG(a2.precioVenta) FROM Articulo a2)";
            TypedQuery<Articulo> query13 = em.createQuery(jpql13, Articulo.class);
            List<Articulo> articulosMayoresAlPromedio = query13.getResultList();
            for (Articulo a : articulosMayoresAlPromedio) {
                System.out.println("Artículo: " + a.getDenominacion() + ", Precio Venta: " + a.getPrecioVenta());
            }

            //Ejercicio 14: Explique y ejemplifique la cláusula EXISTS
            /*
            La cláusula EXISTS es usada para probar la existencia de cualquier registro en una subconsulta.
            Devuelve TRUE si la subconsulta devuelve una o más filas, y FALSE si la subconsulta no devuelve ninguna fila.
             */
            System.out.println("\n--- Ejercicio 14: Artículos que tienen al menos una Imagen (Usando EXISTS) ---");
            String jpql14 = "SELECT a FROM Articulo a WHERE EXISTS (SELECT 1 FROM Imagen i WHERE i MEMBER OF a.imagenes)";
            TypedQuery<Articulo> query14 = em.createQuery(jpql14, Articulo.class);
            List<Articulo> articulosConImagen = query14.getResultList();
            for (Articulo a : articulosConImagen) {
                System.out.println("Artículo con Imagen: " + a.getDenominacion() + " (ID: " + a.getId() + ")");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
    }
}

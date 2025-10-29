package org.example;

import funciones.FuncionApp;

import org.h2.tools.Server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
//        try {
//            Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
//            System.out.println("H2 Console started at http://localhost:8082");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
            EntityManager em = emf.createEntityManager();

            // Persistir la entidad UnidadMedida en estado "gestionada"
            em.getTransaction().begin();
            // Crear una nueva entidad UnidadMedida en estado "nueva"
            UnidadMedida unidadMedida = UnidadMedida.builder()
                    .denominacion("Kilogramo")
                    .build();
            UnidadMedida unidadMedidapote = UnidadMedida.builder()
                    .denominacion("pote")
                    .build();

            em.persist(unidadMedida);
            em.persist(unidadMedidapote);


            // Crear una nueva entidad Categoria en estado "nueva"
            Categoria categoria = Categoria.builder()
                    .denominacion("Frutas")
                    .esInsumo(true)
                    .build();

            // Crear una nueva entidad Categoria en estado "nueva"
            Categoria categoriaPostre = Categoria.builder()
                    .denominacion("Postre")
                    .esInsumo(false)
                    .build();

            // Persistir la entidad Categoria en estado "gestionada"

            em.persist(categoria);
            em.persist(categoriaPostre);


            // Crear una nueva entidad ArticuloInsumo en estado "nueva"
            ArticuloInsumo articuloInsumo = ArticuloInsumo.builder()
                    .denominacion("Manzana").codigo(java.util.UUID.randomUUID().toString())
                    .precioCompra(1.5)
                    .precioVenta(5d)
                    .stockActual(100)
                    .stockMaximo(200)
                    .esParaElaborar(true)
                    .unidadMedida(unidadMedida)
                    .build();


            ArticuloInsumo articuloInsumoPera = ArticuloInsumo.builder()
                    .denominacion("Pera").codigo(java.util.UUID.randomUUID().toString())
                    .precioCompra(2.5)
                    .precioVenta(10d)
                    .stockActual(130)
                    .stockMaximo(200)
                    .esParaElaborar(true)
                    .unidadMedida(unidadMedida)
                    .build();

            // Persistir la entidad ArticuloInsumo en estado "gestionada"

            em.persist(articuloInsumo);
            em.persist(articuloInsumoPera);

            Imagen manza1 = Imagen.builder().denominacion("Manzana Verde").
                    build();
            Imagen manza2 = Imagen.builder().denominacion("Manzana Roja").
                    build();

            Imagen pera1 = Imagen.builder().denominacion("Pera Verde").
                    build();
            Imagen pera2 = Imagen.builder().denominacion("Pera Roja").
                    build();


            // Agregar el ArticuloInsumo a la Categoria
            categoria.getArticulos().add(articuloInsumo);
            categoria.getArticulos().add(articuloInsumoPera);
            // Actualizar la entidad Categoria en la base de datos

            // em.merge(categoria);

            // Crear una nueva entidad ArticuloManufacturadoDetalle en estado "nueva"
            ArticuloManufacturadoDetalle detalleManzana = ArticuloManufacturadoDetalle.builder()
                    .cantidad(2)
                    .articuloInsumo(articuloInsumo)
                    .build();


            ArticuloManufacturadoDetalle detallePera = ArticuloManufacturadoDetalle.builder()
                    .cantidad(2)
                    .articuloInsumo(articuloInsumoPera)
                    .build();

            // Crear una nueva entidad ArticuloManufacturado en estado "nueva"
            ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.builder()
                    .denominacion("Ensalada de frutas")
                    .descripcion("Ensalada de manzanas y peras ")
                    .codigo(java.util.UUID.randomUUID().toString())
                    .precioVenta(150d)
                    .tiempoEstimadoMinutos(10)
                    .preparacion("Cortar las frutas en trozos pequeños y mezclar")
                    .unidadMedida(unidadMedidapote)
                    .build();

            articuloManufacturado.getImagenes().add(manza1);
            articuloManufacturado.getImagenes().add(pera1);

            categoriaPostre.getArticulos().add(articuloManufacturado);
            // Crear una nueva entidad ArticuloManufacturadoDetalle en estado "nueva"

            // Agregar el ArticuloManufacturadoDetalle al ArticuloManufacturado
            articuloManufacturado.getDetalles().add(detalleManzana);
            articuloManufacturado.getDetalles().add(detallePera);
            // Persistir la entidad ArticuloManufacturado en estado "gestionada"
            categoriaPostre.getArticulos().add(articuloManufacturado);
            em.persist(articuloManufacturado);
            em.getTransaction().commit();

            // modificar la foto de manzana roja
            em.getTransaction().begin();
            articuloManufacturado.getImagenes().add(manza2);
            em.merge(articuloManufacturado);
            em.getTransaction().commit();

            //creo y guardo un cliente
            em.getTransaction().begin();
            Cliente cliente = Cliente.builder()
                    .cuit("20123456789")
                    .razonSocial("Juan Perez")
                    .build();
            em.persist(cliente);
            em.getTransaction().commit();

            //creo y guardo una factura
            em.getTransaction().begin();

            FacturaDetalle detalle1 = new FacturaDetalle(3, articuloInsumo);
            detalle1.calcularSubTotal();
            FacturaDetalle detalle2 = new FacturaDetalle(3, articuloInsumoPera);
            detalle2.calcularSubTotal();
            FacturaDetalle detalle3 = new FacturaDetalle(3, articuloManufacturado);
            detalle3.calcularSubTotal();

            Factura factura = Factura.builder()
                    .puntoVenta(2024)
                    .fechaAlta(new Date())
                    .fechaComprobante(FuncionApp.generateRandomDate())
                    .cliente(cliente)
                    .nroComprobante(233L)
                    .build();
            factura.addDetalleFactura(detalle1);
            factura.addDetalleFactura(detalle2);
            factura.addDetalleFactura(detalle3);
            factura.calcularTotal();

            em.persist(factura);
            em.getTransaction().commit();


            // <-------------------------------------------------------------->

            // TRABAJO PRACTICO CONSULTAS JQPL

            // Ejercicio 1: Listar todos los clientes
            System.out.println(" ---- Ejercicio 1: Listar todos los clientes");

            Query query1 = em.createQuery("SELECT c FROM Cliente c");
            List<Cliente> clientes = query1.getResultList();
            System.out.println("Listando clientes...");
            int i = 0;
            for (Cliente c : clientes) {
                i++;
                System.out.println(i + ". " + c.getCuit());
            }
            System.out.println("Total de clientes: " + i);

            // Ejercicio 2: Listar todas las facturas generadas en el último mes
            System.out.println(" ---- Ejercicio 2: Listar todas las facturas generadas en el último mes");

            Query query2 = em.createQuery("SELECT f FROM Factura f WHERE f.fechaComprobante >= FUNCTION('DATEADD', 'MONTH', -1, CURRENT_DATE()) ");
            List<Factura> facturas = query2.getResultList();
            System.out.println("Listando facturas del ultimo mes...");
            i = 0;
            for (Factura f : facturas) {
                i++;
                System.out.println(i + ". " + f.getNroComprobante() + " realizada el " + f.getFechaComprobante());
            }
            System.out.println("Total de facturas del ultimo mes: " + i);


            // Ejercicio 3: Obtener el cliente que ha generado más facturas (Versión optimizada)
            System.out.println("Ejercicio 3: Obtener el cliente que ha generado más facturas");


            Query query3_jpql = em.createQuery(
                    "SELECT c, COUNT(f) FROM Cliente c " +
                            "JOIN c.facturas f " +
                            "GROUP BY c " +
                            "ORDER BY COUNT(f) DESC"
            );
            query3_jpql.setMaxResults(1);


            Object[] resultado = (Object[]) query3_jpql.getSingleResult();


            Cliente clienteConMasFacturas = (Cliente) resultado[0];
            Long cantidadDeFacturas = (Long) resultado[1];



            System.out.println("El cliente que ha generado más facturas es \"" + clienteConMasFacturas.getCuit() + "\" (CUIT)" +
                    ". Con un total de " + cantidadDeFacturas + " facturas.");


            // Ejercicio 4: Listar los artículos más vendidos
            System.out.println("Ejercicio 4: Listar los artículos más vendidos");

            Query query4_jpql = em.createQuery(
                    "SELECT fd.articulo, SUM(fd.cantidad) " +
                            "FROM FacturaDetalle fd " +
                            "GROUP BY fd.articulo " +
                            "ORDER BY SUM(fd.cantidad) DESC"
            );

            query4_jpql.setMaxResults(5);

            List<Object[]> resultadoVentas = query4_jpql.getResultList();

            if (resultadoVentas.isEmpty()) {
                System.out.println("No se encontraron artículos vendidos.");
            } else {
                for (int index = 0; index < resultadoVentas.size(); index++) {
                    Articulo articulo = (Articulo) resultadoVentas.get(index)[0];
                    Number cantidadVendida = (Number) resultadoVentas.get(index)[1];

                    System.out.println(
                            (index + 1) + ". " + articulo.getDenominacion() +
                                    " (Cantidad total vendida: " + cantidadVendida + ")"
                    );
                }
            }


            // Ejercicio 5: Consultar las facturas emitidas en los 3 últimos meses de un cliente específico
            System.out.println("Ejercicio 5: Consultar las facturas emitidas en los 3 últimos meses de un cliente específico");

            Query query5_jpql = em.createQuery("SELECT f FROM Factura f WHERE f.cliente.cuit = :cuit AND f.fechaComprobante >= FUNCTION('DATEADD', 'MONTH', -3, CURRENT_DATE()) ");
            query5_jpql.setParameter("cuit", "20123456789");

            List<Factura> resultadosFactura = query5_jpql.getResultList();
            i=0;
            for ( Factura f : resultadosFactura){
                i++;
                System.out.println(i+". "+f);
            }


            // Ejercicio 6: Calcular el monto total facturado por un cliente
            System.out.println("Ejercicio 6: Calcular el monto total facturado por un cliente");

            Query query6_jpql = em.createQuery("SELECT SUM(f.total) FROM Factura f WHERE f.cliente.cuit = :cuit");
            query6_jpql.setParameter("cuit", "20123456789");

            System.out.println("El monto generado por el cliente cuyo cuit es 20123456789, es de: "+ query6_jpql.getSingleResult());


            // Ejercicio 7: Listar los Artículos vendidos en una factura
            System.out.println("Ejercicio 7: Listar los Artículos vendidos en una factura");

            Query query7_jpql = em.createQuery("SELECT a FROM Factura f JOIN f.detallesFactura d JOIN d.articulo a WHERE f.nroComprobante = :nroComprobante");
            query7_jpql.setParameter("nroComprobante", 233L);

            List<Articulo> resultados7 = query7_jpql.getResultList();
            System.out.println("Los articulos de la factura 233, son: ");
            System.out.println(resultados7.stream().map(Articulo::getDenominacion).collect(Collectors.joining(",","[","]")));


            // Ejercicio 8: Obtener el Artículo más caro vendido en una factura
            System.out.println("Ejercicio 8: Obtener el Artículo más caro vendido en una factura");

            Query query8 = em.createQuery("SELECT a FROM Factura f JOIN f.detallesFactura d JOIN d.articulo a WHERE f.nroComprobante = :nroComprobante ORDER BY a.precioVenta DESC");
            query8.setParameter("nroComprobante", 233L);
            query8.setMaxResults(1);
            Articulo resultado8 = (Articulo) query8.getSingleResult();

            System.out.println("El articulo más caro vendido en la factura con nro de comprobante 223, es: " + resultado8.getDenominacion());



            // Ejercicio 9: Contar la cantidad total de facturas generadas en el sistema
            System.out.println("Ejercicio 9: Contar la cantidad total de facturas generadas en el sistema");

            Query query9 = em.createQuery("SELECT COUNT(f) FROM Factura f");

            Long res9 = (Long) query9.getSingleResult();

            System.out.println("La cantidad total de facturas generadas en el sistema es: " + res9);



            // Ejercicio 10: Listar las facturas cuyo total es mayor a un valor determinado
            System.out.println("Ejercicio 10: Listar las facturas cuyo total es mayor a un valor determinado");

            Query query10 = em.createQuery("SELECT f FROM Factura f WHERE f.total > :facturastotal");
            query10.setParameter("facturastotal", 1d);

            List<Factura> res10 = query10.getResultList();

            System.out.println("Las facturas cuyo total excede 10 son: " + res10.stream().map(Factura::getNroComprobante).map(String::valueOf).collect(Collectors.joining(",","[","]")));


            // Ejercicio 11: Consultar las facturas que contienen un Artículo específico, filtrando por el nombre del artículo
            System.out.println("Ejercicio 11: Consultar las facturas que contienen un Artículo específico, filtrando por el nombre del artículo");

            Query query11 = em.createQuery(
                    "SELECT DISTINCT f FROM Factura f " +
                            "JOIN f.detallesFactura d " +
                            "JOIN d.articulo a " +
                            "WHERE a.denominacion = :denominacion"
            );
            query11.setParameter("denominacion", "Manzana");

            List<Factura> res11 = query11.getResultList();


            System.out.println("Las facturas (NroComprobante) que contienen el artículo \"Manzana\" son: " +
                    res11.stream()
                            .map(Factura::getNroComprobante) // -> Obtiene el Long del NroComprobante
                            .map(String::valueOf)            // -> Convierte el Long a String
                            .collect(Collectors.joining(",", "[", "]"))
            );



            // Ejercicio 12: Listar los Artículos filtrando por código parcial
            System.out.println("Ejercicio 12: Listar los Artículos filtrando por código parcial");

            Query query12 = em.createQuery("");



            // Ejercicio 13: Listar todos los Artículos cuyo precio sea mayor que el promedio de los precios de todos los Artículos
            System.out.println("Ejercicio 13: Listar todos los Artículos cuyo precio sea mayor que el promedio de los precios de todos los Artículos");

            Query query13 = em.createQuery("");




            // Ejercicio 14: Explique y ejemplifique la cláusula EXISTS aplicando la misma en el modelo aplicado en el presente trabajo practico
            System.out.println("Ejercicio 14: Explique y ejemplifique la cláusula EXISTS aplicando la misma en el modelo aplicado en el presente trabajo practico");

            Query query14 = em.createQuery("");







            // FIN TRABAJO PRÁCTICO

            // <-------------------------------------------------------------->

            // Cerrar el EntityManager y el EntityManagerFactory
            em.close();
            emf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

/*

Manejo del Ciclo de Estados en JPA
El ciclo de estados en JPA (Java Persistence API) define los diferentes estados que puede tener una entidad en relación con el contexto de persistencia (EntityManager). Comprender y manejar correctamente estos estados es crucial para trabajar eficazmente con JPA. Los estados del ciclo de vida de una entidad en JPA son:

New (Nuevo):

Una entidad está en estado "New" cuando ha sido creada pero aún no ha sido persistida en la base de datos.
Managed (Gestionado):

Una entidad está en estado "Managed" cuando está asociada con un contexto de persistencia (EntityManager) y cualquier cambio en la entidad se reflejará automáticamente en la base de datos.
Detached (Desconectado):

Una entidad está en estado "Detached" cuando ya no está asociada con un contexto de persistencia. Los cambios en la entidad no se reflejarán automáticamente en la base de datos.
Removed (Eliminado):

Una entidad está en estado "Removed" cuando ha sido marcada para su eliminación en la base de datos.
*/



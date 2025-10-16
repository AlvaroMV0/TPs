package org.example;

import funciones.FuncionApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
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
                    .cuit(FuncionApp.generateRandomCUIT())
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
                    .nroComprobante(FuncionApp.generateRandomNumber())
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
            Query query2 = em.createQuery("SELECT f FROM Factura f WHERE f.fechaComprobante >= FUNCTION('DATEADD', 'MONTH', -1, CURRENT_DATE()) ");
            List<Factura> facturas = query2.getResultList();
            System.out.println("Listando facturas del ultimo mes...");
            i = 0;
            for (Factura f : facturas) {
                i++;
                System.out.println(i + ". " + f.getNroComprobante() + " realizada el " + f.getFechaComprobante());
            }
            System.out.println("Total de facturas del ultimo mes: " + i);


            // Ejercicio 3: Obtener el cliente que ha generado más facturas

            Query query3_jpql = em.createQuery(
                    "SELECT c FROM Cliente c JOIN c.facturas f GROUP BY c ORDER BY COUNT(f) DESC"
            );
            query3_jpql.setMaxResults(1);
            Cliente resultadoCliente = (Cliente) query3_jpql.getSingleResult();
            System.out.println("El cliente que ha generado más facturas es \""+ cliente.getCuit()+"\" (CUIT)" +
                    ". Con un total de "+Optional.ofNullable(resultadoCliente)
                    .map(Cliente::getFacturas)
                    .map(List::size)           
                    .orElse(0)  +" facturas.");



            // Ejercicio 4: Listar los artículos más vendidos


            // Ejercicio 5: Consultar las facturas emitidas en los 3 últimos meses de un cliente específico


            // Ejercicio 6: Calcular el monto total facturado por un cliente


            // Ejercicio 7: Listar los Artículos vendidos en una factura


            // Ejercicio 8: Obtener el Artículo más caro vendido en una factura


            // Ejercicio 9: Contar la cantidad total de facturas generadas en el sistema


            // Ejercicio 10: Listar las facturas cuyo total es mayor a un valor determinado


            // Ejercicio 11: Consultar las facturas que contienen un Artículo específico, filtrando por
            // el nombre del artículo


            // Ejercicio 12: Listar los Artículos filtrando por código parcial


            // Ejercicio 13: Listar todos los Artículos cuyo precio sea mayor que el promedio de los
            // precios de todos los Artículos


            // Ejercicio 14: Explique y ejemplifique la cláusula EXISTS aplicando la misma en el
            // modelo aplicado en el presente trabajo practico


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



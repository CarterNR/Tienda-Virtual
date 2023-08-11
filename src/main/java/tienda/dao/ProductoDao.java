/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tienda.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tienda.domain.Categoria;
import tienda.domain.Producto;

/**
 *
 * @author NIKY
 */
public interface ProductoDao extends JpaRepository<Producto, Long> {

    // Consulta Spring Data JPA para buscar productos por rango de precio ordenados por descripción
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
// Consulta JPQL personalizada para buscar productos por rango de precio usando parámetros
@Query(value="SELECT a FROM Producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
public List<Producto> metodoJPQL (@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

// Consulta nativa personalizada para buscar productos por rango de precio usando parámetros
@Query(nativeQuery=true,
value="SELECT * FROM producto WHERE producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
public List<Producto> metodoNativo (@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);



}

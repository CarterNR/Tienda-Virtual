/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tienda.service;

import java.util.List;
import tienda.domain.Producto;

/**
 *
 * @author NIKY
 */
public interface ProductoService {
    
    // Obtiene una lista de productos con opción de filtrar por activos
    public List<Producto> getProductos(boolean activos);
    
     // Obtiene un producto a partir de su objeto producto
    public Producto getProducto(Producto producto);
    
    // Guarda un nuevo producto si el id del producto está vacío, o actualiza uno existente
    public void save(Producto producto);
    
    // Elimina un producto basado en su objeto producto
    public void delete(Producto producto);
    
    // Busca productos por rango de precio y los ordena por descripción
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    // Ejecuta consulta JPQL personalizada para buscar productos por rango de precio
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
    
    // Ejecuta consulta nativa personalizada para buscar productos por rango de precio
    public List<Producto> metodoNativo(double precioInf, double precioSup);
}

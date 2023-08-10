/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tienda.domain.Producto;
import tienda.service.CategoriaService;
import tienda.service.ProductoService;


@Controller
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/producto/listado")
    public String inicio(Model model) {
        // Obtiene la lista de productos y la agrega al modelo para la vista
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);

        return "/producto/listado";// Devuelve la vista de listado de productos
    }
    }

    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Producto producto, Model model) {
// Prepara la vista del formulario para crear un nuevo producto
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/producto/modificar";
    }

    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto) {
// Guarda un producto y redirige a la lista de productos
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/producto/modificar/{idProducto}")
    public String modificarProducto(Producto producto, Model model) {
// Obtiene un producto y lo agrega al modelo para el formulario de modificación
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modificar";// Devuelve la vista de formulario de modificación

    }

    @GetMapping("/producto/eliminar/{idProducto}")
    public String eliminarProducto(Producto producto) {
// Elimina un producto y redirige a la lista de productos
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }
}

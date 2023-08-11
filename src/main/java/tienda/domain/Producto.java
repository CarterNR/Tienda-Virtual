/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;



@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto; // Identificador único del producto
    private String descripcion;// Descripción del producto
    private String detalle;// Detalle o información adicional sobre el producto
    private double precio;// Precio del producto
    private int existencias;// Cantidad disponible del producto
    private String rutaImagen;// Ruta de la imagen del producto
    private boolean activo;// Indica si el producto está activo
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    Categoria categoria;// Categoría a la que pertenece el producto
    
    public Producto(){
    }
    
    public Producto(String descripcion, String detalle, double precio, int existencias, String imagen, boolean activo){
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.rutaImagen = imagen;
        this.activo = activo;
    }
}

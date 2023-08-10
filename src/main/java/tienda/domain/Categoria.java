package tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Long idCategoria;// Identificador único de la categoría
    private String descripcion;// Descripción de la categoría
    private String rutaImagen; // Ruta de la imagen de la categoría
    private boolean activo; // Ruta de la imagen de la categoría

    @OneToMany
    @JoinColumn(name="id_categoria")
    List<Producto> productos;// Productos asociados a la categoría
    
    public Categoria() {
    }

    public Categoria(String categoria, boolean activo) {
        this.descripcion = categoria;
        this.activo = activo;
    }
}

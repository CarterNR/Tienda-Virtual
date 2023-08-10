package tienda.service;

import tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    // Obtiene una lista de categorías con opción de filtrar por activos
    public List<Categoria> getCategorias(boolean activos);
    
    // Obtiene una categoría a partir de su objeto categoría
    public Categoria getCategoria(Categoria categoria);
    
    // Guarda una nueva categoría si el id está vacío, o actualiza una existente
    public void save (Categoria categoria);
    
    // Elimina una categoría basada en su objeto categoría
    public void delete (Categoria categoria);
}

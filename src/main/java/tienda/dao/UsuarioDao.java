/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tienda.dao;
import tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    
    // Busca un usuario por su nombre de usuario
    Usuario findByUsername(String username);
    
    // Busca un usuario por nombre de usuario y contraseña
    Usuario findByUsernameAndPassword(String username, String password);
    
 // Busca un usuario por nombre de usuario o correo electrónico
    Usuario findByUsernameOrCorreo(String username, String correo);
    
// Verifica si existe un usuario por nombre de usuario o correo electrónico
    boolean existsByUsernameOrCorreo(String username, String correo);
}

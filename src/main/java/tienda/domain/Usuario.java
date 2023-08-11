/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;// Identificador único del usuario
    
    @NotEmpty
    private String username;// Nombre de usuario

    @NotEmpty
    private String password;  // Contraseña
    private String nombre;  // Nombre del usuario
    private String apellidos;  // Apellidos del usuario
    private String correo;  // Correo electrónico del usuario
    private String telefono;  // Número de teléfono del usuario
    private String rutaImagen;  // Ruta de la imagen del usuario
    private boolean activo;  // Indica si el usuario está activo

    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;// Roles asociados al usuario

}

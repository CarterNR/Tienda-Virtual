/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tienda.service;

import tienda.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface RegistroService {

    // Activa un usuario y actualiza el modelo con los resultados
    public Model activar(Model model, String usuario, String clave);

    // Crea un nuevo usuario y actualiza el modelo con los resultados
    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException;
    
    // Activa un usuario y carga una imagen asociada
    public void activar(Usuario usuario, MultipartFile imagenFile);
    
    // Envía un recordatorio al usuario y actualiza el modelo con los resultados
    public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException;
}
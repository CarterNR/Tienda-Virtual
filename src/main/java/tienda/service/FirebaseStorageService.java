/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tienda.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {
     // Carga una imagen en el almacenamiento de Firebase usando un archivo local, una carpeta y un ID
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    
    // Constantes para el nombre del bucket, rutas y nombre de archivo JSON de Firebase
    final String BucketName = "loom-ca57c.appspot.com";
    final String rutaSuperiorStorage = "Loom";
    final String rutaJsonFile = "firebase";
    final String archivoJsonFile = "loom-ca57c-firebase-adminsdk-fuobk-6517d7bcb7";
}

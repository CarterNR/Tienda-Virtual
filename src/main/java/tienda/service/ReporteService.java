/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tienda.service;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author NIKY
 */
public interface ReporteService {
     // Genera un reporte con los parámetros y tipo de archivo especificados
    public ResponseEntity<Resource> generateReporte (
        String reporte,
        Map<String, Object> parametros,
        String tipo
    ) throws IOException;
}

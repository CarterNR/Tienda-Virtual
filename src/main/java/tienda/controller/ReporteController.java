/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tienda.service.ReporteService;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    ReporteService reporteService;
    
    @GetMapping("/principal")
    public String principal (Model model){
        // Prepara las fechas de inicio y fin para el rango de reporte
        Calendar fecha = Calendar.getInstance();
        String fechaIni=""+(fecha.get(Calendar.YEAR)-1)+"-01-01";
        
        String strMes = (fecha.get(Calendar.MONTH)<10?"0":"")+
                fecha.get(Calendar.MONTH);
        
        String strDia = (fecha.get(Calendar.DAY_OF_MONTH)<10?"0":"")+
                fecha.get(Calendar.DAY_OF_MONTH);
        
        String fechaFin=""+fecha.get(Calendar.YEAR)+"-"+strMes+"-"+strDia;
        
        model.addAttribute("fechaInicio", fechaIni);
        model.addAttribute("fechaFin", fechaFin);
        return "/reportes/principal";// Devuelve la vista de reporte principal
    }
    
    @GetMapping("/usuarios")
    public ResponseEntity<Resource> reporteClientes(@RequestParam String tipo) throws IOException{
        // Genera el reporte de usuarios y devuelve la respuesta
        var reporte = "usuarios";
        return reporteService.generateReporte(reporte, null, tipo);
    }
    
    @GetMapping("/ventas")
    public ResponseEntity<Resource> reporteVentas(@RequestParam String tipo) throws IOException{
        // Genera el reporte de ventas y devuelve la respuesta
        var reporte = "ventas";
        return reporteService.generateReporte(reporte, null, tipo);
    }
    
    @GetMapping("/ventasTotales")
    public ResponseEntity<Resource> reporteClientes(@RequestParam String fechaInicio, @RequestParam String fechaFin,
    @RequestParam String tipo) throws IOException{
        Map<String, Object> parametros = new HashMap();
        parametros.put("fechaInicio", fechaInicio);
        parametros.put("fechaFin", fechaFin);
        var reporte = "ventasTotales";
        return reporteService.generateReporte(reporte, parametros, tipo);
    }
    
    @GetMapping("/Categorias")
    public ResponseEntity<Resource> reporteCategorias(@RequestParam String tipo) throws IOException{
        var reporte = "Categorias";
        return reporteService.generateReporte(reporte, null, tipo);
    }
    
    @GetMapping("/facturas")
    public ResponseEntity<Resource> reporteFacturas(@RequestParam String tipo) throws IOException{
        var reporte = "facturas";
        return reporteService.generateReporte(reporte, null, tipo);
    }
}

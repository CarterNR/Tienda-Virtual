/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tienda.domain.Venta;

public interface VentaDao extends JpaRepository <Venta,Long> {
     
}
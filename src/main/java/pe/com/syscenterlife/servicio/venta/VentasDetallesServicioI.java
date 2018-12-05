/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.venta;

import java.util.List;
import pe.com.syscenterlife.modelo.VentVentasDetalles;

/**
 *
 * @author edwil
 */
public interface VentasDetallesServicioI {
    public List<VentVentasDetalles> listarEntidad();
    public List<VentVentasDetalles> listarEntidadDato(String dato);
    public VentVentasDetalles buscarEntidadId(int id);
    public void guardarEntidad(VentVentasDetalles ventasdetalles);
    public void eliminarEntidad(int id);
    public void modificarEntidad(VentVentasDetalles ventasdetalles);
}

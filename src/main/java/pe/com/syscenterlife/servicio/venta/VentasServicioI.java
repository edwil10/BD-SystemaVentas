/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.venta;

import java.util.List;
import pe.com.syscenterlife.modelo.VentVentas;

/**
 *
 * @author edwil
 */
public interface VentasServicioI {
    public List<VentVentas> listarEntidad();
    public List<VentVentas> listarEntidadDato(String dato);
    public VentVentas buscarEntidadId(int id);
    public void guardarEntidad(VentVentas ventas);
    public void eliminarEntidad(int id);
    public void modificarEntidad(VentVentas ventas);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.venta;

import java.util.List;
import pe.com.syscenterlife.modelo.VentClientes;

/**
 *
 * @author edwil
 */
public interface VclientesServicioI {
    public List<VentClientes> listarEntidad();
    public List<VentClientes> listarEntidadDato(String dato);
    public VentClientes buscarEntidadId(int id);
    public void guardarEntidad(VentClientes vclientes);
    public void eliminarEntidad(int id);
    public void modificarEntidad(VentClientes vclientes);
}

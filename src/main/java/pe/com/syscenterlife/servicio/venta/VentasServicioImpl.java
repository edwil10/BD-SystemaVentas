/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.venta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.syscenterlife.dao.venta.VentasDaoI;
import pe.com.syscenterlife.modelo.VentVentas;

/**
 *
 * @author edwil
 */
@Service
@Transactional
public class VentasServicioImpl implements VentasServicioI{
    @Autowired
    public VentasDaoI daoI;

    @Override
    public List<VentVentas> listarEntidad() {
        return daoI.listarEntidad(); 
    }

    @Override
    public List<VentVentas> listarEntidadDato(String dato) {
        return daoI.listarEntidadDato(dato); 
    }

    @Override
    public VentVentas buscarEntidadId(int id) {
        return daoI.buscarEntidadId(id); 
    }

    @Override
    public void guardarEntidad(VentVentas ventas) {
        daoI.guardarEntidad(ventas); 
    }

    @Override
    public void eliminarEntidad(int id) {
        daoI.eliminarEntidad(id); 
    }

    @Override
    public void modificarEntidad(VentVentas ventas) {
        daoI.modificarEntidad(ventas); 
    }
}

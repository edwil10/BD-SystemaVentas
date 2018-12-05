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

import pe.com.syscenterlife.dao.venta.VentasDetallesDaoI;

import pe.com.syscenterlife.modelo.VentVentasDetalles;

/**
 *
 * @author edwil
 */
@Service
@Transactional
public class VentasDetallesServicioImpl implements VentasDetallesServicioI{
    @Autowired
    public VentasDetallesDaoI daoI;

    @Override
    public List<VentVentasDetalles> listarEntidad() {
        return daoI.listarEntidad(); 
    }

    @Override
    public List<VentVentasDetalles> listarEntidadDato(String dato) {
        return daoI.listarEntidadDato(dato); 
    }

    @Override
    public VentVentasDetalles buscarEntidadId(int id) {
        return daoI.buscarEntidadId(id); 
    }

    @Override
    public void guardarEntidad(VentVentasDetalles ventasdetalles) {
        daoI.guardarEntidad(ventasdetalles); 
    }

    @Override
    public void eliminarEntidad(int id) {
        daoI.eliminarEntidad(id); 
    }

    @Override
    public void modificarEntidad(VentVentasDetalles ventasdetalles) {
        daoI.modificarEntidad(ventasdetalles); 
    }
}

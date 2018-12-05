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
import pe.com.syscenterlife.dao.venta.VclientesDaoI;
import pe.com.syscenterlife.modelo.VentClientes;

/**
 *
 * @author edwil
 */
@Service
@Transactional
public class VclientesServicioImpl implements VclientesServicioI{
    @Autowired
    public VclientesDaoI daoI;

    @Override
    public List<VentClientes> listarEntidad() {
        return daoI.listarEntidad(); 
    }

    @Override
    public List<VentClientes> listarEntidadDato(String dato) {
        return daoI.listarEntidadDato(dato); 
    }

    @Override
    public VentClientes buscarEntidadId(int id) {
        return daoI.buscarEntidadId(id); 
    }

    @Override
    public void guardarEntidad(VentClientes vclientes) {
        daoI.guardarEntidad(vclientes); 
    }

    @Override
    public void eliminarEntidad(int id) {
        daoI.eliminarEntidad(id); 
    }

    @Override
    public void modificarEntidad(VentClientes vclientes) {
        daoI.modificarEntidad(vclientes); 
    }
}

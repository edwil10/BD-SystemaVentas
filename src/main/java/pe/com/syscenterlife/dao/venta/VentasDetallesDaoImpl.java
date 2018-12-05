/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.venta;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.VentVentasDetalles;

/**
 *
 * @author edwil
 */
@Repository
public class VentasDetallesDaoImpl extends SysDataAccess<Integer, VentVentasDetalles> implements VentasDetallesDaoI{
    @SuppressWarnings("unchecked")

    @Override
    public List<VentVentasDetalles> listarEntidad() {
        return getListAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VentVentasDetalles> listarEntidadDato(String dato) {
          return (List<VentVentasDetalles>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from VentVentasDetalles p WHERE CONCAT(p.nombre,' ', p.direccion) LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list();                
                } 
    

    @Override
    public VentVentasDetalles buscarEntidadId(int id) {
        return getById(id); 
    }

    @Override
    public void guardarEntidad(VentVentasDetalles ventasdetalles) {
        savev(ventasdetalles); 
    }

    @Override
    public void eliminarEntidad(int id) {
        delete(id); 
    }

    @Override
    public void modificarEntidad(VentVentasDetalles ventasdetalles) {
        update(ventasdetalles); 
    }
}

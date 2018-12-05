/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.venta;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.VentVentas;

/**
 *
 * @author edwil
 */
@Repository
public class VentasDaoImpl extends SysDataAccess<Integer, VentVentas> implements VentasDaoI{
    @SuppressWarnings("unchecked")

    @Override
    public List<VentVentas> listarEntidad() {
        return getListAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VentVentas> listarEntidadDato(String dato) {
          return (List<VentVentas>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from VentVentas p WHERE p.nombre LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list();                
                } 
    

    @Override
    public VentVentas buscarEntidadId(int id) {
        return getById(id); 
    }

    @Override
    public void guardarEntidad(VentVentas ventas) {
        savev(ventas); 
    }

    @Override
    public void eliminarEntidad(int id) {
        delete(id); 
    }

    @Override
    public void modificarEntidad(VentVentas ventas) {
        update(ventas); 
    }
}

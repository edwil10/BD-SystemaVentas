/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.venta;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.VentClientes;


/**
 *
 * @author edwil
 */
@Repository
public class VclientesDaoImpl extends SysDataAccess<Integer, VentClientes> implements VclientesDaoI{
    @SuppressWarnings("unchecked")

    @Override
    public List<VentClientes> listarEntidad() {
        return getListAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VentClientes> listarEntidadDato(String dato) {
          return (List<VentClientes>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from VentClientes p WHERE CONCAT(p.idventa,' ', p.idMovVnt) LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list();                
                } 

    @Override
    public VentClientes buscarEntidadId(int id) {
        return getById(id); 
    }

    @Override
    public void guardarEntidad(VentClientes vclientes) {
        savev(vclientes); 
    }

    @Override
    public void eliminarEntidad(int id) {
        delete(id); 
    }

    @Override
    public void modificarEntidad(VentClientes vclientes) {
        update(vclientes); 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.control.venta;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pe.com.syscenterlife.modelo.VentVentas;

import pe.com.syscenterlife.servicio.venta.VentasServicioI;
//import pe.com.syscenterlife.utils.STRCrypto;

/**
 *
 * @author edwil
 */
@Controller
public class VentasControl {
    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    VentasServicioI ventasServicioI;
    
    Logger logger = Logger.getLogger(VentasControl.class.getName());
    
@RequestMapping(value = {"/ventMain" }, method = RequestMethod.GET)    
public ModelAndView inicioVentas(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Edwin"}, locale);
    List<VentVentas> lista=ventasServicioI.listarEntidad();

    model.put("ListaVentas", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("venta/ventas/mainVentas");
}


@RequestMapping(value = {"/elimvent" }, method = RequestMethod.GET)
public ModelAndView eliminarVenta(HttpServletRequest r){
    int idEntidad=Integer.parseInt(r.getParameter("id"));
    ventasServicioI.eliminarEntidad(idEntidad);
return new ModelAndView(new RedirectView("/ventMain"));
}
  
@RequestMapping(value = {"/buscarvent"}, method = RequestMethod.POST)
public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"edwin Mamani"}, locale);
    String dato=r.getParameter("dato");
    List<VentVentas> lista=ventasServicioI.listarEntidadDato(dato);
    model.put("ListaVentas", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");    
return new ModelAndView("venta/ventas/mainVentas");
}


@RequestMapping(value = "/guardarVentas", method = RequestMethod.POST)
public ModelAndView guardarEntidad(@ModelAttribute("modeloVentas")VentVentas ventas,
        BindingResult result, HttpServletRequest r){
        //STRCrypto crypt=new STRCrypto();
        //ventas.setIdMovVnt(ventasServicioI.IdMovVnt().getId());
        
        logger.info("Imprimir ID: "+ventas.getIdMovVnt());    
        try {
        //persona.setClave(crypt.encrypt(ventas.getClave()));
        ventasServicioI.guardarEntidad(ventas);
        return new ModelAndView(new RedirectView("/ventMain"));
        } catch (Exception e) { 
        logger.info("Error Guardar: "+e.getMessage());    
        return new ModelAndView(new RedirectView("/formVentas"));
        }    
}

@RequestMapping(value = "/formModifVenta", method = RequestMethod.GET)
public ModelAndView irModificarVenta(HttpServletRequest r ){
   int id=Integer.parseInt(r.getParameter("id"));
       VentVentas entidad=null;
       entidad=ventasServicioI.buscarEntidadId(id);
    return new ModelAndView("venta/ventas/mainVentas","modeloVentas",entidad);
}


@RequestMapping(value = "actualizarVentas", method = RequestMethod.POST)
public ModelAndView actualizarVenta(@ModelAttribute("modeloVentas") VentVentas entidad,
                                      BindingResult result, HttpServletRequest r ){
        //STRCrypto crypt=new STRCrypto();
        try {
        //entidad.setClave(crypt.encrypt(entidad.getClave()));
        ventasServicioI.modificarEntidad(entidad);
        return new ModelAndView(new RedirectView(r.getContextPath()+"/ventMain"));
    } catch (Exception e) {
        logger.info("Error al modificar: "+e.getMessage());
        return new ModelAndView(new RedirectView(r.getContextPath()+"/formModif2Ventas?id="+entidad.getIdMovVnt()));
    }
    
}
}

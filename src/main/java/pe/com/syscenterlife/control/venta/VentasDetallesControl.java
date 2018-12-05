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
import pe.com.syscenterlife.control.global.PersonaControl;

import pe.com.syscenterlife.modelo.VentVentasDetalles;

import pe.com.syscenterlife.servicio.venta.VentasDetallesServicioI;
//import pe.com.syscenterlife.utils.STRCrypto;

/**
 *
 * @author edwil
 */
@Controller
public class VentasDetallesControl {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    VentasDetallesServicioI ventasDetallesServicioI;

    
    Logger logger = Logger.getLogger(PersonaControl.class.getName());
    
@RequestMapping(value = {"/ventDMain" }, method = RequestMethod.GET)    
public ModelAndView inicio(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"edwin Mamani"}, locale);
    List<VentVentasDetalles> lista=ventasDetallesServicioI.listarEntidad();

    model.put("ListaPersona", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("venta/ventasdetalles/mainVentasDetalles");
}


@RequestMapping(value = {"/elimventD" }, method = RequestMethod.GET)
public ModelAndView eliminarVentaD(HttpServletRequest r){
    int idEntidad=Integer.parseInt(r.getParameter("id"));
    ventasDetallesServicioI.eliminarEntidad(idEntidad);
return new ModelAndView(new RedirectView("/ventDMain"));
}
  
@RequestMapping(value = {"/buscarventD"}, method = RequestMethod.POST)
public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Edwin Mamani"}, locale);
    String dato=r.getParameter("dato");
    List<VentVentasDetalles> lista=ventasDetallesServicioI.listarEntidadDato(dato);
    model.put("ListaVentaD", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");    
return new ModelAndView("venta/ventasdetalles/mainVentasDetalles");
}

@RequestMapping(value = "/formVentasDetalles", method = RequestMethod.GET)
public ModelAndView irFormulario(@ModelAttribute("modeloVentaD")VentVentasDetalles ventaD,
        BindingResult result, Model model){
        

        Map<String,String> idioma = new LinkedHashMap<String,String>();
        idioma.put("en", "Ingles");
        idioma.put("es", "Español");

        model.addAttribute("urlAccion", "guardarVentaD"); 
        
        model.addAttribute("ListIdioma", idioma); 
    return new ModelAndView("venta/ventasdetalles/formVentasDetalles");
}

@RequestMapping(value = "/guardarVentaD", method = RequestMethod.POST)
public ModelAndView guardarEntidad(@ModelAttribute("modeloVentaD")VentVentasDetalles ventaD,
        BindingResult result, HttpServletRequest r){
        //STRCrypto crypt=new STRCrypto();
        //ventaD.setIdVentaDetalle(ventasDetallesServicioI.idVentaDetalleGenerator().getId());
        
        logger.info("Imprimir ID: "+ventaD.getIdVentaDetalle());    
        try {
        //ventaD.setClave(crypt.encrypt(ventaD.getClave()));
        ventasDetallesServicioI.guardarEntidad(ventaD);
        return new ModelAndView(new RedirectView("/ventDMain"));
        } catch (Exception e) { 
        logger.info("Error Guardar: "+e.getMessage());    
        return new ModelAndView(new RedirectView("/formVentasDetalles"));
        }    
}

@RequestMapping(value = "/formModifVentD", method = RequestMethod.GET)
public ModelAndView irModificarPersona(HttpServletRequest r ){
   int id=Integer.parseInt(r.getParameter("id"));
       VentVentasDetalles entidad=null;
       entidad=ventasDetallesServicioI.buscarEntidadId(id);
    return new ModelAndView("venta/ventasdetalles/mainVentasDetalles","modeloVentD",entidad);
}

@RequestMapping(value = "/formModif2VentaD", method = RequestMethod.GET)
public String irModificar2Persona(HttpServletRequest r, Model model ){
   int id=Integer.parseInt(r.getParameter("id"));
       VentVentasDetalles ventaD=null;
       ventaD=ventasDetallesServicioI.buscarEntidadId(id);
       logger.info("Error ImpuestoIGV Real "+ventaD.getImpuestoigv());        

        Map<String,String> idioma = new LinkedHashMap<String,String>();
        idioma.put("en", "Ingles");
        idioma.put("es", "Español");       
        model.addAttribute("modeloVentaD", ventaD);  
        
        model.addAttribute("ListIdioma", idioma);
        
        model.addAttribute("urlAccion", "actualizarVentaD");             
    return "venta/ventasdetalles/mainVentasDetalles";
}

@RequestMapping(value = "actualizarVentaD", method = RequestMethod.POST)
public ModelAndView actualizarPersona(@ModelAttribute("modeloVentaD") VentVentasDetalles entidad,
                                      BindingResult result, HttpServletRequest r ){
        //STRCrypto crypt=new STRCrypto();
        try {
        //entidad.setClave(crypt.encrypt(entidad.getClave()));
        ventasDetallesServicioI.modificarEntidad(entidad);
        return new ModelAndView(new RedirectView(r.getContextPath()+"/ventDMain"));
    } catch (Exception e) {
        logger.info("Error al modificar: "+e.getMessage());
        return new ModelAndView(new RedirectView(r.getContextPath()+"/formModif2VentaD?id="+entidad.getIdVentaDetalle()));
    }
    
}
    
}

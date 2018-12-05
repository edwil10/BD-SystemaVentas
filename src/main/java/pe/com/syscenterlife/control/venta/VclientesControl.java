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
import pe.com.syscenterlife.modelo.VentClientes;

import pe.com.syscenterlife.servicio.venta.VclientesServicioI;


/**
 *
 * @author edwil
 */
@Controller
public class VclientesControl {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    VclientesServicioI vclientesServicioI;

    
    Logger logger = Logger.getLogger(PersonaControl.class.getName());
    


@RequestMapping(value = {"/elimvcli" }, method = RequestMethod.GET)
public ModelAndView eliminarVentaD(HttpServletRequest r){
    int idEntidad=Integer.parseInt(r.getParameter("id"));
    vclientesServicioI.eliminarEntidad(idEntidad);
return new ModelAndView(new RedirectView("/vcliMain"));
}
  
@RequestMapping(value = {"/buscarvcli"}, method = RequestMethod.POST)
public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Edwin Mamani"}, locale);
    String dato=r.getParameter("dato");
    List<VentClientes> lista=vclientesServicioI.listarEntidadDato(dato);
    model.put("ListaVclientes", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");    
return new ModelAndView("venta/vclientes/mainVclientes");
}

@RequestMapping(value = "/formVclientes", method = RequestMethod.GET)
public ModelAndView irFormulario(@ModelAttribute("modeloVclientes")VentClientes vclientes,
        BindingResult result, Model model){
        

        Map<String,String> idioma = new LinkedHashMap<String,String>();
        idioma.put("en", "Ingles");
        idioma.put("es", "Español");

        model.addAttribute("urlAccion", "guardarVclientes"); 
        
        model.addAttribute("ListIdioma", idioma); 
    return new ModelAndView("venta/vclientes/formVclientes");
}

@RequestMapping(value = "/guardarVcli", method = RequestMethod.POST)
public ModelAndView guardarEntidad(@ModelAttribute("modeloVcli")VentClientes vclientes,
        BindingResult result, HttpServletRequest r){
        //STRCrypto crypt=new STRCrypto();
        //ventaD.setIdVentaDetalle(ventasDetallesServicioI.idVentaDetalleGenerator().getId());
        
        logger.info("Imprimir ID: "+vclientes.getIdCliente());    
        try {
        //ventaD.setClave(crypt.encrypt(ventaD.getClave()));
        vclientesServicioI.guardarEntidad(vclientes);
        return new ModelAndView(new RedirectView("/vcliMain"));
        } catch (Exception e) { 
        logger.info("Error Guardar: "+e.getMessage());    
        return new ModelAndView(new RedirectView("/formVclientes"));
        }    
}

@RequestMapping(value = "/formModifVcli", method = RequestMethod.GET)
public ModelAndView irModificarPersona(HttpServletRequest r ){
   int id=Integer.parseInt(r.getParameter("id"));
       VentClientes entidad=null;
       entidad=vclientesServicioI.buscarEntidadId(id);
    return new ModelAndView("venta/vclientes/mainVclientes","modeloVcli",entidad);
}

@RequestMapping(value = "/formModif2Vcli", method = RequestMethod.GET)
public String irModificar2Vcli(HttpServletRequest r, Model model ){
   int id=Integer.parseInt(r.getParameter("id"));
       VentClientes vcli=null;
       vcli=vclientesServicioI.buscarEntidadId(id);
       logger.info("Error Nombre Real "+vcli.getNombre());        

        Map<String,String> idioma = new LinkedHashMap<String,String>();
        idioma.put("en", "Ingles");
        idioma.put("es", "Español");       
        model.addAttribute("modeloVcli", vcli);  
        
        model.addAttribute("ListIdioma", idioma);
        
        model.addAttribute("urlAccion", "actualizarVcli");             
    return "venta/vclientes/mainVclientes";
}

@RequestMapping(value = "actualizarVcli", method = RequestMethod.POST)
public ModelAndView actualizarPersona(@ModelAttribute("modeloVcli") VentClientes entidad,
                                      BindingResult result, HttpServletRequest r ){
        //STRCrypto crypt=new STRCrypto();
        try {
        //entidad.setClave(crypt.encrypt(entidad.getClave()));
        vclientesServicioI.modificarEntidad(entidad);
        return new ModelAndView(new RedirectView(r.getContextPath()+"/vcliMain"));
    } catch (Exception e) {
        logger.info("Error al modificar: "+e.getMessage());
        return new ModelAndView(new RedirectView(r.getContextPath()+"/formModif2Vcli?id="+entidad.getIdCliente()));
    }
    
}
 
   @RequestMapping(value = {"/vcliMain"}, method = RequestMethod.GET)
    public ModelAndView inicio(Locale locale, Map<String, Object> model) {
        String welcome = messageSource.getMessage("welcome.message", new Object[]{"-A-N-O-N-Y-M-O-U-S-"}, locale);
        List<VentClientes> lista = vclientesServicioI.listarEntidad();

        model.put("ListaVclientes", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");
        return new ModelAndView("venta/vclientes/mainVclientes");
    }
    
//  
//  @RequestMapping(value = {"/buscarvcli"}, method = RequestMethod.POST)
//    public  ModelAndView buscarEntidad(Map<String,Object> model, HttpServletRequest r, @ModelAttribute("modeloVcli")VentClientes vcl,
//        BindingResult result){
//        String dato=r.getParameter("dato");
//        List<VentClientes> lista=vclientesServicioI.listarEntidadDato(dato);
//        model.put("ListaVclientes", lista);
//        model.put("noresults", "No matches were found.");
//        model.put("accion", "Add...");
//        return new ModelAndView("venta/vclientes/mainVclientes");
//    } 
//
//    @RequestMapping(value = {"/elimvcli"}, method = RequestMethod.GET)
//    public ModelAndView eliminarPersona(HttpServletRequest r) {
//        int idEntidad = Integer.parseInt(r.getParameter("id"));
//        vclientesServicioI.eliminarEntidad(idEntidad);
//        return new ModelAndView(new RedirectView("/vcliMain"));
//    }

//    @RequestMapping(value = "/formvcli", method = RequestMethod.GET)
//    public ModelAndView irFormulario(@ModelAttribute("modeloVcli") VentClientes vcl,
//            BindingResult result, Map<String,Object> model) {
//        List<GloUnidadMedida> Umedida = unidadmedidaServicioI.listarEntidad();
//        model.put("urlAccion", "guardarUMP");
//        model.put("ListarUnidadMedida", Umedida);
////
//        List<GloProductos> producto = productoServicioI.listarEntidad();
//        model.put("ListaProducto", producto);
//        return new ModelAndView("global/unidadmediproducto/formUnimPro");
//    }
////
// @RequestMapping(value = "/guardarUMP", method = RequestMethod.POST)
//    public ModelAndView guardarEntidad(@ModelAttribute("modeloump") GloUnidadmedProducto ump, BindingResult result, Model model){        
//        
//     try {
//            if(ump.getIdUnidMedProducto()== null)
//            UmedidaproductoServicioI.guardarEntidad(ump);
//	else
//            UmedidaproductoServicioI.modificarEntidad(ump);
//        
//     } catch (Exception e) { logger.info("ERRROR :"+e.getMessage());
//     }
//     return new ModelAndView(new RedirectView("/prodMain"));
//    } 
//
//    
//      @RequestMapping(value = {"/formModifump" }, method = RequestMethod.GET)
//    public ModelAndView actualizarEntidad(HttpServletRequest r, Map<String,Object> model){
//        int idEntidad=Integer.parseInt(r.getParameter("id"));       
//        List<GloUnidadmedProducto> lista = UmedidaproductoServicioI.listarEntidad();
//        model.put("ListaUniMediProducto", lista);
//        model.put("modeloump",UmedidaproductoServicioI.buscarEntidadId(idEntidad));
//        model.put("accion", "Edit...");
//        List<GloUnidadMedida> Umedida = unidadmedidaServicioI.listarEntidad();
//        model.put("urlAccion", "guardarUMP");
//        model.put("ListarUnidadMedida", Umedida);
////
//        List<GloProductos> producto = productoServicioI.listarEntidad();
//        model.put("ListaProducto", producto);
//        return new ModelAndView("global/unidadmediproducto/formUnimPro");
//    }
}

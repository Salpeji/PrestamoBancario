
//package com.example.BancoSpringDemo;
package com.example.web;

import com.example.dominio.Persona;
import com.example.dominio.Prestamo;
import com.example.servicio.PersonaServicio;
import com.example.servicio.PrestamoServicio;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@RestController
@Controller
@Slf4j
public class ControladorREST {
    
    
    @Autowired
    
    
    private PersonaServicio personaServicio;
    
    private PrestamoServicio prestamoServicio;
    
    
    @GetMapping("/")
    public String comienzo(Model model){
        
        
        //Iterable<Persona> personas = ipersonaDao.findAll();
        List<Persona> personas = personaServicio.listaPersonas();
        log.info("Estoy ejecutnado el controlador MVC");
        model.addAttribute("personas", personas);
        return "indice";
    }
    
    // -------------- Se crean endpoint con MVC para clientes ---------------
    @GetMapping("/anexar")
    public String anexar(Persona persona){
        return "cambiar";
    }
    
    @PostMapping("/salvar")
    public String salvar(@Valid Persona persona, Errors error){
        if(error.hasErrors()){
            return "cambiar";
        }
        personaServicio.salvar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/cambiar/{id_individuo}")
    public String cambiar(Persona persona, Model model){
        persona = persona = personaServicio.localizarPersona(persona);
        model.addAttribute("persona", persona);
        return "cambiar";
    }
    
    @GetMapping("/borrar")
    public String borrar(Persona persona){
        personaServicio.borrar(persona);
        return "redirect:/";
    }
    
    
    // ------ Se crean endpoint con MVC para los prestamos Solicitados ---------    
    @GetMapping("/solicitarPrestamo")
    public String solicitarPrestamo(Prestamo prestamo){
        return "prestamoCliente";
    }
    
    
    @PostMapping("/procesarSolicitud")
    public String salvar(@Valid Prestamo prestamo, Errors error){
        if(error.hasErrors()){
            return "prestamoCliente";
        }
        prestamoServicio.guardarPrestamo(prestamo);
        return "redirect:/";
    }
    
    
    
}


package com.registro2.CRUD.controller;

import com.registro2.CRUD.model.Persona;
import com.registro2.CRUD.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author MyVICTIUS
 */ 

    @Controller
    @RequestMapping("/personas")
public class PersonaController {
   @Autowired
   private PersonaService personaService;

   public PersonaController() {
   }

   @GetMapping
   public String listarPersonas(Model model) {
      model.addAttribute("personas", this.personaService.listarTodas());
      return "persona-list";
   }

   @GetMapping({"/"})
   public String mostrarPaginaInicio() {
      return "index";
   }

   @GetMapping({"/nuevo"})
   public String mostrarFormularioNuevaPersona(Model model) {
      model.addAttribute("persona", new Persona());
      return "persona-form";
   }

   @PostMapping
   public String guardarPersona(Persona persona) {
      this.personaService.guardar(persona);
      return "redirect:/personas";
   }

   @GetMapping({"/editar/{id}"})
   public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model) {
      model.addAttribute("persona", this.personaService.obtenerPorId(id));
      return "persona-form";
   }

   @GetMapping({"/eliminar/{id}"})
   public String eliminarPersona(@PathVariable Long id) {
      this.personaService.eliminar(id);
      return "redirect:/personas";
   }
}
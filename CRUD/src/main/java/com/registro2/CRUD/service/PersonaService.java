/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registro2.CRUD.service;

import com.registro2.CRUD.model.Persona;
import com.registro2.CRUD.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MyVICTIUS
 */      
 
@Service
public class PersonaService {
   @Autowired
   private PersonaRepository personaRepository;

   public PersonaService() {
   }

   public List<Persona> listarTodas() {
      return this.personaRepository.findAll();
   }

   public Persona guardar(Persona persona) {
      return (Persona)this.personaRepository.save(persona);
   }

   public Persona obtenerPorId(Long id) {
      return (Persona)this.personaRepository.findById(id).orElse((Persona)(Object)null);
   }

   public void eliminar(Long id) {
      this.personaRepository.deleteById(id);
   }
}

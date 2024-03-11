package com.example.dao;

import com.example.dominio.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao  extends CrudRepository<Persona, Long>{
    
    
}

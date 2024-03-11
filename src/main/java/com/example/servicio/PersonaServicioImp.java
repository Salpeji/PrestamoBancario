package com.example.servicio;

import com.example.dao.IPersonaDao;
import com.example.dominio.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonaServicioImp implements PersonaServicio {
    
    
    @Autowired
    private IPersonaDao ipersonaDao;

    
    @Override
    @Transactional(readOnly=true)
    public List<Persona> listaPersonas() {
        return (List<Persona>) ipersonaDao.findAll();
    }

    @Override
    @Transactional
    public void salvar(Persona persona) {
        ipersonaDao.save(persona);
    }

    @Override
    @Transactional
    public void borrar(Persona persona) {
        ipersonaDao.delete(persona);

    }

    @Override
    @Transactional(readOnly = true)
    public Persona localizarPersona(Persona persona) {
        return ipersonaDao.findById(persona.getId_individuo()).orElse(null);
    }
    
}

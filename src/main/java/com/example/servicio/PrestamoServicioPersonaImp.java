/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.servicio;

import com.example.dao.IPrestamoDe;
import com.example.dominio.Prestamo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author samuelPerez
 */

@Service
public class PrestamoServicioPersonaImp implements PrestamoServicio{
    
    @Autowired
    private IPrestamoDe iprestamoDe;
    
    

    @Override
    @Transactional(readOnly=true) // Rollback por ser operacion transacional y que permita se de lectura
    public List<Prestamo> listaPrestamos() {
        return (List<Prestamo>) iprestamoDe.findAll();
    }

    @Override
    @Transactional // Rollback por ser operacion transacional para guardar prestamo
    public void guardarPrestamo(Prestamo prestamo) {
        iprestamoDe.save(prestamo);
    }

    @Override
    @Transactional // eliminacion de prestamo si el cliente lo cancela todo
    public void eliminarPrestamo(Prestamo prestamo) {
        iprestamoDe.delete(prestamo);
    }

    @Override // Consultar el prestamo por el id del cliente.
    @Transactional(readOnly = true )
    public Prestamo localizarPrestamoPersona(Prestamo prestamo) {
        return iprestamoDe.findById(prestamo.getIdprestamo()).orElse(null);
    }
    
    
}

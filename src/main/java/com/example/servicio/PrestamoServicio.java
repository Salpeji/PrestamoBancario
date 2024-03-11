/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.servicio;

import com.example.dominio.Prestamo;
import java.util.List;

/**
 *
 * @author samuelPerez
 */
public interface PrestamoServicio {
    
    public List<Prestamo> listaPrestamos();
    
    public void guardarPrestamo(Prestamo prestamo);
    
    public void eliminarPrestamo(Prestamo prestamo);
    
    public Prestamo localizarPrestamoPersona(Prestamo prestamo);
    
}

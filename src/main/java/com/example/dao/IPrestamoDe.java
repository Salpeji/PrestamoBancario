/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.dominio.Prestamo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author samuelPerez
 */

public interface IPrestamoDe extends CrudRepository<Prestamo, Long> {
    
}

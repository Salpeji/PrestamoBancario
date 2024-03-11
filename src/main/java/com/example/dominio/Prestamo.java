/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author samuelPerez
 */


@Data
@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotEmpty
    private Long idprestamo;
    
    @NotEmpty
    private String montosolicitado;
    
    @NotEmpty
    private String plazo;
    
    @NotEmpty
    private String cuotamensual;
    
    @NotEmpty
    private String fechapago;
    
    @NotEmpty
    private String estado;
    
    @NotEmpty
    private String detalle;
    
    @NotEmpty
    private String fechafinalpago;
    
    @NotEmpty
    private Long persona_id_individuo;
            
    
    
}

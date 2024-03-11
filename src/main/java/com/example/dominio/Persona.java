package com.example.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_individuo;
    
    
    @NotEmpty
    private String nombre;
    
    
    
    @NotEmpty
    private String apellido;
    
    
    
    @NotEmpty
    private String numeroidentificacion;
    
    
    
    @NotEmpty
    private String fechanacimiento;
    
    
    
    @NotEmpty
    private String direccion;
    
    
    @NotEmpty
    private String correo;
    
    
    
    private String telefono;
    
    
    
    
    
    
            
    
    
    
    
}

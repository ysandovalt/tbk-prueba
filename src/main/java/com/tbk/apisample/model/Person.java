package com.tbk.apisample.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "personas")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor  
public class Person {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String nombre;
    private String apellido;
    private String email;
    
}

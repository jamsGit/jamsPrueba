package com.example.tienda.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Entity 
@Entity 
@Table(name = "productos")

//lombok
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//hiberante
@Audited

public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//clases
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "status")
	private boolean status;
    
	     
	/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_precio")
	private Precio precioP;*/  

	
		

}

package com.example.tienda.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Entity 
@Entity 
@Table(name = "precios")

//lombok
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//hiberante
@Audited

// clases

public class Precio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "precio")
	private double precio;
	@Column(name = "status")
	private boolean status;
	
		

}
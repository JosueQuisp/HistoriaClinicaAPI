package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pacientes")

public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; 
	
	@Column(name = "nombre", length = 55)
	private String nombre; 
	
	@Column(name = "apellidos", length = 55)
	private String apellidos; 
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nac")
	private Date fecha_nac; 
	
	@Column(name = "direccion", length = 45)
	private String direccion;
	
	@Column(name = "telefono", length = 9)
	private String telefono; 

	
	//relacion de uno a muchos de paciete consulta 
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paciente")
	@JsonIgnore
	private Set<Consulta> consulta;
	
	
	
}

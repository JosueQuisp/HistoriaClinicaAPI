package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Paciente;

public interface PacienteService {
	
	Paciente create(Paciente c); 
	Paciente update(Paciente c); 
    void delete(Long id); 
    Optional<Paciente> read(Long id );
    List<Paciente> readAll(); 
    

}

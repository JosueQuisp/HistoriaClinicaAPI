package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Diagnostico;

public interface DiagnosticoService {
	
	Diagnostico create(Diagnostico c); 
	Diagnostico update(Diagnostico c); 
    void delete(Long id); 
    Optional<Diagnostico> read(Long id );
    List<Diagnostico> readAll(); 
    

}

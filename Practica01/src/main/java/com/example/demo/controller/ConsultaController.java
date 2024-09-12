package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Consulta;
import com.example.demo.service.ConsultaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService; 
	
	@GetMapping
	public ResponseEntity<List<Consulta>> readAll(){
		try {
			List<Consulta> consulta= consultaService.readAll(); 
			if (consulta.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(consulta, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
    
	
	@PostMapping
	public ResponseEntity<Consulta> create(@Valid @RequestBody Consulta c){
		try {
			Consulta conss= consultaService.create(c); 
			return new ResponseEntity<>(conss, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> getconsulta(@PathVariable("id") Long id){
		Optional<Consulta> consul= consultaService.read(id); 
		return consul.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Consulta> updateconsulta(@PathVariable("id") Long id, @Valid @RequestBody Consulta consulta){
		 Optional<Consulta> existingconsulta = consultaService.read(id);
	        if (existingconsulta.isPresent()) {
	            consulta.setId(id);
	            return new ResponseEntity<>(consultaService.update(consulta), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteconsulta(@PathVariable("id") Long id) {
        try {
            consultaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
}

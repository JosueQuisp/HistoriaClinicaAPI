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
import com.example.demo.entity.Especialidad;
import com.example.demo.service.EspecialidadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/especialidades")

public class EspecialidadController {
	
	@Autowired
	private EspecialidadService especialidadService; 
	
	@GetMapping
	public ResponseEntity<List<Especialidad>> readAll(){
		try {
			List<Especialidad> espe= especialidadService.readAll(); 
			if (espe.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(espe, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Especialidad> create(@Valid @RequestBody Especialidad c){
		try {
			Especialidad espe= especialidadService.create(c); 
			return new ResponseEntity<>(espe, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidad> getespecialidad(@PathVariable("id") Long id){
		Optional<Especialidad> espe= especialidadService.read(id); 
		return espe.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Especialidad> updateespecialidad(@PathVariable("id") Long id, @Valid @RequestBody Especialidad especialidad){
		 Optional<Especialidad> existing = especialidadService.read(id);
	        if (existing.isPresent()) {
	            especialidad.setId(id);
	            return new ResponseEntity<>(especialidadService.update(especialidad), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAcceso(@PathVariable("id") Long id) {
        try {
            especialidadService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	
	
	
}

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
import com.example.demo.entity.Diagnostico;
import com.example.demo.service.DiagnosticoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController {
	
	@Autowired
	private DiagnosticoService diagnosticoService;
	
	@GetMapping
	public ResponseEntity<List<Diagnostico>> readAll(){
		try {
			List<Diagnostico> diag= diagnosticoService.readAll(); 
			if (diag.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(diag, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Diagnostico> create(@Valid @RequestBody Diagnostico c){
		try {
			Diagnostico diag = diagnosticoService.create(c); 
			return new ResponseEntity<>(diag, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Diagnostico> getDiagnostico(@PathVariable("id") Long id){
		Optional<Diagnostico> dia= diagnosticoService.read(id); 
		return dia.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Diagnostico> updatediagnostico(@PathVariable("id") Long id, @Valid @RequestBody Diagnostico diagnostico){
		 Optional<Diagnostico> existingdiag = diagnosticoService.read(id);
	        if (existingdiag.isPresent()) {
	        	diagnostico.setId(id);
	            return new ResponseEntity<>(diagnosticoService.update(diagnostico), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletediagnostico(@PathVariable("id") Long id) {
        try {
            diagnosticoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
}

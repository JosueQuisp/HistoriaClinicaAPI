package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Diagnostico;
import com.example.demo.repository.DiagnosticoRepositoy;
import com.example.demo.service.DiagnosticoService;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService{
    
	@Autowired
	private DiagnosticoRepositoy diagnosticoRepositoy; 
	
	@Override
	public Diagnostico create(Diagnostico c) {
		// TODO Auto-generated method stub
		return diagnosticoRepositoy.save(c);
	}

	@Override
	public Diagnostico update(Diagnostico c) {
		// TODO Auto-generated method stub
		return diagnosticoRepositoy.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		diagnosticoRepositoy.deleteById(id);
	}

	@Override
	public Optional<Diagnostico> read(Long id) {
		// TODO Auto-generated method stub
		return diagnosticoRepositoy.findById(id);
	}

	@Override
	public List<Diagnostico> readAll() {
		// TODO Auto-generated method stub
		return diagnosticoRepositoy.findAll();
	}

}

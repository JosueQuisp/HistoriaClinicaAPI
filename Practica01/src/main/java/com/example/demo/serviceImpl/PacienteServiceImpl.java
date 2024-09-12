package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Paciente;
import com.example.demo.repository.PacienteRepositoy;
import com.example.demo.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{
	
	@Autowired
	private PacienteRepositoy pacienteRepositoy;

	@Override
	public Paciente create(Paciente c) {
		// TODO Auto-generated method stub
		return pacienteRepositoy.save(c);
	}

	@Override
	public Paciente update(Paciente c) {
		// TODO Auto-generated method stub
		return pacienteRepositoy.save(c); 
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pacienteRepositoy.deleteById(id);
	}

	@Override
	public Optional<Paciente> read(Long id) {
		// TODO Auto-generated method stub
		return pacienteRepositoy.findById(id);
	}

	@Override
	public List<Paciente> readAll() {
		// TODO Auto-generated method stub
		return pacienteRepositoy.findAll();
	} 
}

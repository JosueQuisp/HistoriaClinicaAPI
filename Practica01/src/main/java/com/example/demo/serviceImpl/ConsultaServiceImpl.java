package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Consulta;
import com.example.demo.repository.ConsultaRepositoy;
import com.example.demo.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService{

	@Autowired
	private ConsultaRepositoy consultaRepositoy; 
	@Override
	public Consulta create(Consulta c) {
		// TODO Auto-generated method stub
		return consultaRepositoy.save(c);
	}

	@Override
	public Consulta update(Consulta c) {
		// TODO Auto-generated method stub
		return consultaRepositoy.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		consultaRepositoy.deleteById(id);
	}

	@Override
	public Optional<Consulta> read(Long id) {
		// TODO Auto-generated method stub
		return consultaRepositoy.findById(id);
	}

	@Override
	public List<Consulta> readAll() {
		// TODO Auto-generated method stub
		return consultaRepositoy.findAll();
	}

}

package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Especialidad;
import com.example.demo.repository.EspecialidadRepositoy;
import com.example.demo.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{
	@Autowired
	private EspecialidadRepositoy especialidadRepositoy; 
	@Override
	public Especialidad create(Especialidad c) {
		// TODO Auto-generated method stub
		return especialidadRepositoy.save(c);
	}

	@Override
	public Especialidad update(Especialidad c) {
		// TODO Auto-generated method stub
		return especialidadRepositoy.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		especialidadRepositoy.deleteById(id);
	}

	@Override
	public Optional<Especialidad> read(Long id) {
		// TODO Auto-generated method stub
		return especialidadRepositoy.findById(id);
	}

	@Override
	public List<Especialidad> readAll() {
		// TODO Auto-generated method stub
		return especialidadRepositoy.findAll();
	}

}

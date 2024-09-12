package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Medico;
import com.example.demo.repository.MedicoRepositoy;
import com.example.demo.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService{
	
	@Autowired
	private MedicoRepositoy medicoRepositoy; 

	@Override
	public Medico create(Medico c) {
		// TODO Auto-generated method stub
		return medicoRepositoy.save(c);
	}

	@Override
	public Medico update(Medico c) {
		// TODO Auto-generated method stub
		return medicoRepositoy.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		medicoRepositoy.deleteById(id);
	}

	@Override
	public Optional<Medico> read(Long id) {
		// TODO Auto-generated method stub
		return medicoRepositoy.findById(id);
	}

	@Override
	public List<Medico> readAll() {
		// TODO Auto-generated method stub
		return medicoRepositoy.findAll();
	}

}

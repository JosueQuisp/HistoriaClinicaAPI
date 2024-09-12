package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Paciente;

public interface PacienteRepositoy  extends JpaRepository<Paciente, Long>{

}

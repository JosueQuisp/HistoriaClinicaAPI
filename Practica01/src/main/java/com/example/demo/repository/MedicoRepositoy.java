package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Medico;

public interface MedicoRepositoy extends JpaRepository<Medico, Long> {

}

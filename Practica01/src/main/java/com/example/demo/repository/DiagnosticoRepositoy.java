package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Diagnostico;

public interface DiagnosticoRepositoy extends JpaRepository<Diagnostico, Long> {

}

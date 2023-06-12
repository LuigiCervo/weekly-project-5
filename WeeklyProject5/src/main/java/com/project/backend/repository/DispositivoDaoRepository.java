package com.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.backend.models.Dispositivo;

@Repository
public interface DispositivoDaoRepository extends JpaRepository<Dispositivo, Long> {

	public Dispositivo findBySeriale (String seriale);
}

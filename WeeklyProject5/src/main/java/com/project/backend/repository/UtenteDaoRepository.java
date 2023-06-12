package com.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.backend.models.Utente;

@Repository
public interface UtenteDaoRepository extends JpaRepository<Utente, Long> {

	public Utente findByUsernameAndEmail (String username, String email);
}

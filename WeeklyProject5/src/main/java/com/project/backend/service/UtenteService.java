package com.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.backend.models.Utente;
import com.project.backend.repository.UtenteDaoRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class UtenteService {

	@Autowired UtenteDaoRepository repo;
	
	public List<Utente> getAllUtenti () {
		return repo.findAll();
	}
	
	public Utente getById (Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("Utente non esistente!!");
		}
		return repo.findById(id).get();
	}
	
	public Utente createUtente (Utente u) {
		if (repo.findByUsernameAndEmail(u.getUsername(), u.getEmail()) !=null) {
			throw new EntityExistsException("Utente già esistente");
		}
		return repo.save(u);
	}
	
	public Utente updateUtente (Long id, Utente u) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("Utente non esistente!!");
		}
		return repo.save(u);
	}
	
	public String deleteUtente (Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("Utente non esistente!!");
		}
		repo.deleteById(id);
		return "Utente eliminato!";
	}
	
	
}

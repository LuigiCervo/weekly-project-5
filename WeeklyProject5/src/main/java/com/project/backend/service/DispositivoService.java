package com.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.backend.models.Dispositivo;
import com.project.backend.repository.DispositivoDaoRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class DispositivoService {

	@Autowired DispositivoDaoRepository repo;
	
	public List<Dispositivo> getAllDispositivi(){
		return repo.findAll();
	}
	
	public Dispositivo getById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Dispositivo inesistente!!");
		}
		return repo.findById(id).get();
	}
	
	public Dispositivo createDispositivo (Dispositivo d) {
		if(repo.findBySeriale(d.getSeriale()) !=null) {
			throw new EntityExistsException("Dispositivo già registrato!!");
		}
		return repo.save(d);
	}
	
	public Dispositivo updateDispositivo (Long id, Dispositivo d) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Dispositivo inesistente!!");
		}
		return repo.save(d);
	}
	
	public String deleteDispositivo (Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Dispositivo inesistente!!");
		}
		repo.deleteById(id);
		return "Dispositivo eliminato!!";
	}
}

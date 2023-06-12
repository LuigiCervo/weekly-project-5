package com.project.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.models.Dispositivo;
import com.project.backend.models.Utente;
import com.project.backend.service.DispositivoService;

@RestController
@RequestMapping("/api/dispositivi")
public class DispositivoController {

	@Autowired DispositivoService dispositivoService;
	
	@GetMapping
	public ResponseEntity<?> getAll (){
		return ResponseEntity.ok(dispositivoService.getAllDispositivi());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById (@PathVariable Long id){
		return ResponseEntity.ok(dispositivoService.getById(id));
	}
	
	@PostMapping
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> create (@RequestBody Dispositivo d){
		return ResponseEntity.ok(dispositivoService.createDispositivo(d));
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")

	public ResponseEntity<?> update (@PathVariable Long id,@RequestBody Dispositivo d){
		return ResponseEntity.ok(dispositivoService.updateDispositivo(id, d));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> delete (@PathVariable Long id){
		return ResponseEntity.ok(dispositivoService.deleteDispositivo(id));
	}
}

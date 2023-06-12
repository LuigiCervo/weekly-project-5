package com.project.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (nullable = false)
	private String tipologia;
	@Column (nullable = false)
	private String modello;
	@Column (nullable = false, unique = true)
	private String seriale;
	@Column (nullable = false)
	private StatoDispositivo stato;
	
	
}

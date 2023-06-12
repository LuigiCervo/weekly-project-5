package com.project.backend.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (nullable = false,  unique = true)
	private String username;
	@Column (nullable = false)
	private String nome;
	@Column (nullable = false)
	private String cognome;
	@Column (nullable = false, unique = true)
	private String email;
	
	@OneToMany
	@JoinTable(name = "dispositivi_in_possesso",
    joinColumns = @JoinColumn(name = "utente_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "dispositivo_id", referencedColumnName = "id")
	)
	private List<Dispositivo> dispositiviInPossesso;
}

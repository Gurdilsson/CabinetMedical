package com.cabinet.cabinet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Secretaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String telephone;
	
	@Column
	private String identifiant;
	
	@Column
	private String mot_de_passe;
	
	public Secretaire(String nom, String prenom, String telephone, String identifiant, String mot_de_passe) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.identifiant = identifiant;
		this.mot_de_passe = mot_de_passe;
	}
	
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public Secretaire() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
}

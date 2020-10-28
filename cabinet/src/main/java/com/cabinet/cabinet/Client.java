package com.cabinet.cabinet;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	
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
	private String profession;

	@Column
	private Date date_naissance;

	@Column
	private String adresse;

	@Column
	private String commentaires;

	@Column
	private String identifiant;

	@Column
	private String mot_de_passe;
	
	@Column
	private int id_dossier;
	
	public Client(String nom, String prenom, String telephone, String profession, Date dateDeNaissance, String adresse, String identifiant, String motDePasse, int idDossier) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.profession = profession;
		this.date_naissance = dateDeNaissance;
		this.adresse = adresse;
		this.identifiant = identifiant;
		this.mot_de_passe = motDePasse;
		this.id_dossier = idDossier;
	}
	
	public Client() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
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
	
	
}

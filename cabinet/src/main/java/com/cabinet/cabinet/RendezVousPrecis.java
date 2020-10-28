package com.cabinet.cabinet;

import java.sql.Timestamp;

public class RendezVousPrecis {

	private int id;
	
	private String nomMedecin;
	
	private String nomClient;
	
	private Timestamp date;
	
	private int niveauUrgence;
	
	private String commentaires;
	
	private int idMedecin;
	
	private int idClient;
	
	public RendezVousPrecis(int id, String nomMedecin, String nomClient, Timestamp date, int niveauUrgence, String commentaires, int idMedecin, int idClient) {
		this.id = id;
		this.nomClient = nomClient;
		this.nomMedecin = nomMedecin;
		this.date = date;
		this.niveauUrgence = niveauUrgence;
		this.commentaires = commentaires;
		this.idMedecin = idMedecin;
		this.idClient = idClient;
	}
	
	public int getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(int idMedecin) {
		this.idMedecin = idMedecin;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public RendezVousPrecis() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomMedecin() {
		return nomMedecin;
	}

	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getNiveauUrgence() {
		return niveauUrgence;
	}

	public void setNiveauUrgence(int niveauUrgence) {
		this.niveauUrgence = niveauUrgence;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
}
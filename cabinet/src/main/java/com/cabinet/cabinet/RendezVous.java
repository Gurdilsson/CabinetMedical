package com.cabinet.cabinet;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RendezVous {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "id_medecin")
	private int medecinId;
	
	@Column(name = "id_client")
	private int clientId;
	
	@Column(name = "date_rdv")
	private Timestamp date;
	
	@Column
	private int niveauUrgence;
	
	@Column
	private String commentaires;
	
	public RendezVous(int medecinId, int clientId, Timestamp date, int niveauUrgence, String commentaires) {
		this.medecinId = medecinId;
		this.clientId = clientId;
		this.date = date;
		this.niveauUrgence = niveauUrgence;
		this.commentaires = commentaires;
	}
	
	public RendezVous() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMedecinId() {
		return medecinId;
	}

	public void setMedecinId(int medecinId) {
		this.medecinId = medecinId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
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

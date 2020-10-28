package com.cabinet.cabinet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretaireManager {
	
	@Autowired
	private SecretaireRepository secretaireRepository;

	public Secretaire findById(int id) {
		return secretaireRepository.findOneById(id);
	}
	
	public List<Secretaire> findByIdentifiant(String identifiant) {
		return secretaireRepository.findAllByIdentifiant(identifiant);
	}
	
	public List<Secretaire> findAll() {
		List<Secretaire> secretaireList = new ArrayList<>();
		secretaireList = (List) secretaireRepository.findAll();
		return secretaireList;
	}
	
	public Secretaire createSecretaire(Secretaire secretaire) {
		secretaireRepository.save(secretaire);
		return secretaire;
	}
	
	public void updateSecretaire(Secretaire ancien, Secretaire nouveau) {
		ancien.setNom(nouveau.getNom());
		ancien.setPrenom(nouveau.getPrenom());
		ancien.setTelephone(nouveau.getTelephone());
		ancien.setIdentifiant(nouveau.getIdentifiant());
		ancien.setMot_de_passe(nouveau.getMot_de_passe());
		secretaireRepository.save(ancien);
	}
	
	public void deleteSecretaire(Secretaire secretaire) {
		secretaireRepository.delete(secretaire);
	}

	

	

}

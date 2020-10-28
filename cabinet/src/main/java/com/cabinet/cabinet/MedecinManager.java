package com.cabinet.cabinet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedecinManager {
	
	@Autowired
	private MedecinRepository medecinRepository;
	
	public Medecin findById(int id) {
		return medecinRepository.findOneById(id);
	}
	
	public List<Medecin> findByIdentifiant(String id) {
		return medecinRepository.findAllByIdentifiant(id);
	}
	
	public List<Medecin> findAll() {
		List<Medecin> medecinList = new ArrayList<>();
		medecinList = (List) medecinRepository.findAll();
		return medecinList;
	}

	public Medecin createMedecin(Medecin medecin) {
		medecinRepository.save(medecin);
		return medecin;
	}

	public void updateMedecin(Medecin ancien, Medecin nouveau) {
		ancien.setNom(nouveau.getNom());
		ancien.setPrenom(nouveau.getPrenom());
		ancien.setTelephone(nouveau.getTelephone());
		ancien.setIdentifiant(nouveau.getIdentifiant());
		ancien.setMot_de_passe(nouveau.getMot_de_passe());
		ancien.setSpecialite(nouveau.getSpecialite());
		medecinRepository.save(ancien);
		
	}

	public void deleteMedecin(Medecin medecin) {
		medecinRepository.delete(medecin);
		
	}

	


}

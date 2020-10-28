package com.cabinet.cabinet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RendezVousManager {
	
	@Autowired
	private RendezVousRepository rendezVousRepository;
	
	public RendezVous findById(int id) {
		return rendezVousRepository.findOneById(id);
	}
	
	public List<RendezVous> findAll() {
		List<RendezVous> rendezVousList = new ArrayList<>();
		rendezVousList = (List) rendezVousRepository.findAll();
		return rendezVousList;
	}

	public RendezVous createRendezVous(RendezVous rdv) {
		rendezVousRepository.save(rdv);
		return rdv;
	}

	public void updateRendezVous(RendezVous ancien, RendezVous nouveau) {
		ancien.setClientId(nouveau.getClientId());
		ancien.setMedecinId(nouveau.getMedecinId());
		ancien.setCommentaires(nouveau.getCommentaires());
		ancien.setDate(nouveau.getDate());
		ancien.setNiveauUrgence(nouveau.getNiveauUrgence());
		rendezVousRepository.save(ancien);		
	}
	
	public void deleteRendezVous(RendezVous rendezVous) {
		rendezVousRepository.delete(rendezVous);
	}

	public List<RendezVous> findAllByIdClient(int id) {
		List<RendezVous> rendezVousList = new ArrayList<>();
		rendezVousList = (List) rendezVousRepository.findAllByClientId(id);
		return rendezVousList;
	}
	
	public List<RendezVous> findAllByIdMedecin(int id) {
		List<RendezVous> rendezVousList = new ArrayList<>();
		rendezVousList = (List) rendezVousRepository.findAllByMedecinId(id);
		return rendezVousList;
	}

}

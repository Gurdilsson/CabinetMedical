package com.cabinet.cabinet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientManager {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client findById(int id) {
		return clientRepository.findOneById(id);
	}

	public List<Client> findByIdentifiant(String identifiant) {
		return clientRepository.findAllByIdentifiant(identifiant);
	}
	
	public List<Client> findAll() {
		List<Client> clientList = new ArrayList<>();
		clientList = (List) clientRepository.findAll();
		return clientList;
	}

	public Client createClient(Client client) {
		clientRepository.save(client);
		return client;
	}

	public void updateClient(Client ancien, Client nouveau) {
		ancien.setNom(nouveau.getNom());
		ancien.setPrenom(nouveau.getPrenom());
		ancien.setTelephone(nouveau.getTelephone());
		ancien.setAdresse(nouveau.getAdresse());
		ancien.setCommentaires(nouveau.getCommentaires());
		ancien.setDate_naissance(nouveau.getDate_naissance());
		ancien.setIdentifiant(nouveau.getIdentifiant());
		ancien.setMot_de_passe(nouveau.getMot_de_passe());
		ancien.setProfession(nouveau.getProfession());
		clientRepository.save(ancien);
		
	}

	public void deleteClient(Client client) {
		clientRepository.delete(client);
		
	}


	

}

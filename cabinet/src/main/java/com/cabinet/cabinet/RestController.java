package com.cabinet.cabinet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {

	@Autowired
	private SecretaireManager secretaireManager;
	
	@Autowired
	private ClientManager clientManager;
	
	@Autowired
	private MedecinManager medecinManager;
	
	@Autowired
	private RendezVousManager rendezVousManager;
	
	//==================================================================================================================================
	//Partie Secretaire
	//==================================================================================================================================
		
	@ResponseBody
	@RequestMapping("/cabinet/secretaire")
    public List<Secretaire> showAllSecretaires() {
		System.out.println("debut showAllSecretaires");
        List<Secretaire> secretaireList = this.secretaireManager.findAll();
        System.out.println("Taille de liste" + secretaireList.size());
        for (Secretaire secretaire : secretaireList) {
			System.out.println("Trouvé : " + secretaire.getNom() + " " + secretaire.getPrenom() + ", tel : " + secretaire.getTelephone());
		}
		System.out.println("fin showAllSecretaires");
		return secretaireList;
    }
	
	@ResponseBody
	@PostMapping(
	value = "/cabinet/secretaire", consumes = "application/json", produces = "application/json")
	public Secretaire createSecretaire(@RequestBody Secretaire secretaire) {
		System.out.println("debut createSecretaire");
		System.out.println("Création : " + secretaire.getNom() + " " + secretaire.getPrenom() + ", tel : " + secretaire.getTelephone());
	    return secretaireManager.createSecretaire(secretaire);  
	}
	
	@ResponseBody
	@PutMapping("/cabinet/secretaire/{id}")
	public ResponseEntity<?> updateSecretaire(@RequestBody Secretaire nouveau, @PathVariable("id") Integer id) {
		System.out.println("debut updateSecretaire");
		Secretaire ancien = secretaireManager.findById(id);
		if (ancien != null) {
			System.out.println("Modification de : " + ancien.getNom() + " " + ancien.getPrenom() + ", tel : " + ancien.getTelephone());
			secretaireManager.updateSecretaire(ancien, nouveau);
			System.out.println("fin updateSecretaire");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("Modification impossible, id non trouvé : " + id);
			System.out.println("fin updateSecretaire");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@DeleteMapping("/cabinet/secretaire/{id}")
	public ResponseEntity<?> deleteSecretaire(@PathVariable Integer id) {
		System.out.println("debut deleteSecretaire");
		Secretaire secretaire = secretaireManager.findById(id);
		if (secretaire != null) {
			System.out.println("Suppression : " + secretaire.getNom() + " " + secretaire.getPrenom() + ", tel : " + secretaire.getTelephone());
			secretaireManager.deleteSecretaire(secretaire);
			System.out.println("fin deleteSecretaire");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("Suppression impossible, id non trouvé : " + id);
			System.out.println("fin deleteSecretaire");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	//==================================================================================================================================
	//Partie Client
	//==================================================================================================================================
	
	@ResponseBody
	@RequestMapping("/cabinet/client")
    public List<Client> showAllClients() {
		System.out.println("debut showAllClient");
        List<Client> clientList = this.clientManager.findAll();
        System.out.println("Taille de liste" + clientList.size());
        for (Client client : clientList) {
			System.out.println("Trouvé : " + client.getNom() + " " + client.getPrenom() + ", tel : " + client.getTelephone());
		}
		System.out.println("fin showAllClients");
		return clientList;
    }
	
	@ResponseBody
	@PostMapping(
	value = "/cabinet/client", consumes = "application/json", produces = "application/json")
	public Client createClient(@RequestBody Client client) {
		System.out.println("debut createClient");
		System.out.println("Création : " + client.getNom() + " " + client.getPrenom() + ", tel : " + client.getTelephone());
	    return clientManager.createClient(client);  
	}
	
	@ResponseBody
	@PutMapping("/cabinet/client/{id}")
	public ResponseEntity<?> updateClient(@RequestBody Client nouveau, @PathVariable("id") Integer id) {
		System.out.println("debut updateClient");
		Client ancien = clientManager.findById(id);
		if (ancien != null) {
			System.out.println("Modification de : " + ancien.getNom() + " " + ancien.getPrenom());
			clientManager.updateClient(ancien, nouveau);
			System.out.println("fin updateClient");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("Modification impossible, id non trouvé : " + id);
			System.out.println("fin updateClient");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/cabinet/client/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable Integer id) {
		System.out.println("debut deleteClient");
		Client client = clientManager.findById(id);
		List<RendezVous> rendezVousASupp = rendezVousManager.findAllByIdClient(id);
		if (client != null) {
			System.out.println("Suppression : " + client.getNom() + " " + client.getPrenom());
			for (RendezVous rendezVous : rendezVousASupp) {
				rendezVousManager.deleteRendezVous(rendezVous);
			}
			clientManager.deleteClient(client);
			System.out.println("fin deleteClient");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("Suppression impossible, id non trouvé : " + id);
			System.out.println("fin deleteClient");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//==================================================================================================================================
	//Partie Medecin
	//==================================================================================================================================
	
	@ResponseBody
	@RequestMapping("/cabinet/medecin")
    public List<Medecin> showAllMedecins() {
		System.out.println("debut showAllMedecins");
        List<Medecin> medecinList = this.medecinManager.findAll();
        System.out.println("Taille de liste" + medecinList.size());
        for (Medecin medecin : medecinList) {
			System.out.println("Trouvé : " + medecin.getNom() + " " + medecin.getPrenom() + ", tel : " + medecin.getTelephone());
		}
		System.out.println("fin showAllMedecins");
		return medecinList;
    }
	
	@ResponseBody
	@PostMapping(
	value = "/cabinet/medecin", consumes = "application/json", produces = "application/json")
	public Medecin createMedecin(@RequestBody Medecin medecin) {
		System.out.println("debut createMedecin");
		System.out.println("Création : " + medecin.getNom() + " " + medecin.getPrenom() + ", tel : " + medecin.getTelephone());
	    return medecinManager.createMedecin(medecin);  
	}
	
	@ResponseBody
	@PutMapping("/cabinet/medecin/{id}")
	public ResponseEntity<?> updateMedecin(@RequestBody Medecin nouveau, @PathVariable("id") Integer id) {
		System.out.println("debut updateMedecin");
		Medecin ancien = medecinManager.findById(id);
		if (ancien != null) {
			System.out.println("Modification de : " + ancien.getNom() + " " + ancien.getPrenom());
			medecinManager.updateMedecin(ancien, nouveau);
			System.out.println("fin updateMedecin");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("Modification impossible, id non trouvé : " + id);
			System.out.println("fin updateMedecin");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/cabinet/medecin/{id}")
	public ResponseEntity<?> deleteMedecin(@PathVariable Integer id) {
		System.out.println("debut deleteMedecin");
		Medecin medecin = medecinManager.findById(id);
		List<RendezVous> rendezVousASupp = rendezVousManager.findAllByIdMedecin(id);
		if (medecin != null) {
			System.out.println("Suppression : " + medecin.getNom() + " " + medecin.getPrenom());
			for (RendezVous rendezVous : rendezVousASupp) {
				rendezVousManager.deleteRendezVous(rendezVous);
			}
			medecinManager.deleteMedecin(medecin);
			
			System.out.println("fin deleteMedecin");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("Suppression impossible, id non trouvé : " + id);
			System.out.println("fin deleteMedecin");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//==================================================================================================================================
	//Partie RdV
	//==================================================================================================================================
	
	@ResponseBody
	@RequestMapping("/cabinet/rendezVous")
	public List<RendezVousPrecis> getRendezVous() {
		System.out.println("debut getRendezVous");
		List<RendezVous> rendezVousList = rendezVousManager.findAll();
		Client client = new Client();
		Medecin medecin = new Medecin();
		List<RendezVousPrecis> rendezVousPrecisList = new ArrayList<>();
		for (RendezVous rendezVous : rendezVousList) {
			client = clientManager.findById(rendezVous.getClientId());
			medecin = medecinManager.findById(rendezVous.getMedecinId());
			rendezVousPrecisList.add(new RendezVousPrecis(
					rendezVous.getId(),
					medecin.getNom() + " " + medecin.getPrenom(),
					client.getNom() + " " + client.getPrenom(),
					rendezVous.getDate(),
					rendezVous.getNiveauUrgence(),
					rendezVous.getCommentaires(),
					rendezVous.getMedecinId(),
					rendezVous.getClientId()));
		}
		return rendezVousPrecisList;
	}
	
	@ResponseBody
	@RequestMapping("/cabinet/rendezVous/client/{id}")
	public List<RendezVousPrecis> getRendezVousClient(@PathVariable Integer id) {
		System.out.println("debut getRendezVousClient");
		List<RendezVousPrecis> rendezVousPrecisList = new ArrayList<>();
		Client client = new Client();
		Medecin medecin = new Medecin();
		List<RendezVous> rendezVousList = rendezVousManager.findAllByIdClient(id);
		for (RendezVous rendezVous : rendezVousList) {
			client = clientManager.findById(rendezVous.getClientId());
			medecin = medecinManager.findById(rendezVous.getMedecinId());
			rendezVousPrecisList.add(new RendezVousPrecis(
					rendezVous.getId(),
					medecin.getNom() + " " + medecin.getPrenom(),
					client.getNom() + " " + client.getPrenom(),
					rendezVous.getDate(),
					rendezVous.getNiveauUrgence(),
					rendezVous.getCommentaires(),
					rendezVous.getMedecinId(),
					rendezVous.getClientId()));
			
			
		}
		return rendezVousPrecisList;
	}
	
	@ResponseBody
	@RequestMapping("/cabinet/rendezVous/medecin/{id}")
	public List<RendezVousPrecis> getRendezVousMedecin(@PathVariable Integer id) {
		System.out.println("debut getRendezVousMedecin");
		List<RendezVousPrecis> rendezVousPrecisList = new ArrayList<>();
		Client client = new Client();
		Medecin medecin = new Medecin();
		List<RendezVous> rendezVousList = rendezVousManager.findAllByIdMedecin(id);
		for (RendezVous rendezVous : rendezVousList) {
			client = clientManager.findById(rendezVous.getClientId());
			medecin = medecinManager.findById(rendezVous.getMedecinId());
			rendezVousPrecisList.add(new RendezVousPrecis(
					rendezVous.getId(),
					medecin.getNom() + " " + medecin.getPrenom(),
					client.getNom() + " " + client.getPrenom(),
					rendezVous.getDate(),
					rendezVous.getNiveauUrgence(),
					rendezVous.getCommentaires(),
					rendezVous.getMedecinId(),
					rendezVous.getClientId()));
			
			
		}
		return rendezVousPrecisList;
	}
	
	@ResponseBody
	@PostMapping(
	value = "/cabinet/rendezVous", consumes = "application/json", produces = "application/json")
	public RendezVous createRendezVous(@RequestBody RendezVous rdv) {
		System.out.println("debut createRendeVous");
	    return rendezVousManager.createRendezVous(rdv);  
	}
	
	@ResponseBody
	@PutMapping("/cabinet/rendezVous/{id}")
	public ResponseEntity<?> updateRendezVous(@RequestBody RendezVous nouveau, @PathVariable("id") Integer id) {
		System.out.println("debut updateRendezVous");
		RendezVous ancien = rendezVousManager.findById(id);
		if (ancien != null) {
			rendezVousManager.updateRendezVous(ancien, nouveau);
			System.out.println("fin updateRendezVous");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("Modification impossible, id non trouvé : " + id);
			System.out.println("fin updateRendezVous");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/cabinet/rendezVous/{id}")
	public ResponseEntity<?> deleteRendezVous(@PathVariable Integer id) {
		System.out.println("debut deleteRendezVous");
		RendezVous rendezVous = rendezVousManager.findById(id);
		if (rendezVous != null) {
			rendezVousManager.deleteRendezVous(rendezVous);
			System.out.println("fin deleteRendezVous");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("Suppression impossible, id non trouvé : " + id);
			System.out.println("fin deleteRendezVous");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//==================================================================================================================================
	//Partie Connexion
	//==================================================================================================================================
	
	@ResponseBody
	@RequestMapping("/cabinet/auth/client/{id}/{mdp}")
	public Client AuthentificationClient(@PathVariable String id, @PathVariable String mdp) {
		System.out.println("Debut authentification client");
		List<Client> listeClient = clientManager.findByIdentifiant(id);
		for (Client client : listeClient) {
			if (client.getMot_de_passe().equals(mdp)) {
				return client;
			}
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/cabinet/auth/medecin/{id}/{mdp}")
	public Medecin AuthentificationMedecin(@PathVariable String id, @PathVariable String mdp) {
		System.out.println("Debut authentification medecin");
		List<Medecin> listeMedecin = medecinManager.findByIdentifiant(id);
		for (Medecin medecin : listeMedecin) {
			if (medecin.getMot_de_passe().equals(mdp)) {
				return medecin;
			}
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/cabinet/auth/secretaire/{id}/{mdp}")
	public Secretaire AuthentificationSecretaire(@PathVariable String id, @PathVariable String mdp) {
		System.out.println("Debut authentification medecin");
		List<Secretaire> listeSecretaire = secretaireManager.findByIdentifiant(id);
		for (Secretaire secretaire : listeSecretaire) {
			if (secretaire.getMot_de_passe().equals(mdp)) {
				return secretaire;
			}
		}
		return null;
	}
	
	
}

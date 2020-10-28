package com.cabinet.cabinet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RendezVousRepository extends CrudRepository<RendezVous, Long>{
	
	RendezVous findOneById(int id);
	
	List<RendezVous> findAllByClientId(int id);
	
	List<RendezVous> findAllByMedecinId(int id);

}

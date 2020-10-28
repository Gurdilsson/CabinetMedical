package com.cabinet.cabinet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MedecinRepository extends CrudRepository<Medecin, Long> {

	Medecin findOneById(int id);
	
	List<Medecin> findAllByIdentifiant(String identifiant);
}

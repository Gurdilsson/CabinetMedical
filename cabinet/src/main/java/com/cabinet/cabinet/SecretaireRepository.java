package com.cabinet.cabinet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
 

public interface SecretaireRepository extends CrudRepository<Secretaire,Long> {

	Secretaire findOneById(int id);
	
	List<Secretaire> findAllByIdentifiant(String identifiant);
}

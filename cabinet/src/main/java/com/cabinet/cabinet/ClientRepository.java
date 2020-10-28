package com.cabinet.cabinet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long>{

	Client findOneById(int id);
	
	List<Client> findAllByIdentifiant(String identifiant);

}

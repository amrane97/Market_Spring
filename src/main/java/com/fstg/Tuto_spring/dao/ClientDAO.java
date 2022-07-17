package com.fstg.Tuto_spring.dao;

import com.fstg.Tuto_spring.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDAO extends JpaRepository<ClientEntity, Integer> {

    ClientEntity findByNom(String nom);

    ClientEntity findByPrenom(String prenom);

    ClientEntity findByTelephone(String telephone);
}

package com.fstg.Tuto_spring.dao;


import com.fstg.Tuto_spring.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductDAO extends JpaRepository<ProductEntity, Integer> {


    // * Question en quoi c'est mieux de dire Optionnel au lieu de Product Entity ?
    // * Reponse internet : il permet de faciliter la manipulation du null

    ProductEntity findProductById(int id);

    Optional<ProductEntity> findProductByLibelle(String libelle);

    ProductEntity findProductByRef(String ref);

    Optional<ProductEntity> findProductByPrix(int prix);

    List<ProductEntity> findByPrixGreaterThan(int prix);

}

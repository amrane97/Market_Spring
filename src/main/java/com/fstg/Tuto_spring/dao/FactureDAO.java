package com.fstg.Tuto_spring.dao;


import com.fstg.Tuto_spring.models.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository // fait qu'il reconnaite un findByRef par exemple
public interface FactureDAO extends JpaRepository<FactureEntity, Integer> {

    public Optional<FactureEntity> findFactureById(int id);

    public Optional<FactureEntity> findFactureByRef (String ref);

    public Optional<FactureEntity> findFactureByDate (Date date);

}

package com.fstg.Tuto_spring.service.implementation;

import com.fstg.Tuto_spring.dao.FactureDAO;
import com.fstg.Tuto_spring.dto.FactureDto;
import com.fstg.Tuto_spring.models.FactureEntity;
import com.fstg.Tuto_spring.service.facade.FactureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("facture1") // je donne un nom a cette implementation comme ça je peux creer une 2eme...etc
public class FactureServiceImpl implements FactureService {

    @Autowired
    private FactureDAO factureDAO;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FactureDto findByRef(String ref) {
        FactureEntity factureEntity = factureDAO.findFactureByRef(ref).orElseThrow();
        return modelMapper.map(factureEntity, FactureDto.class);
    }

    @Override
    public FactureDto findByDate(Date date) {
        FactureEntity factureEntity = factureDAO.findFactureByDate(date).orElseThrow();
        return modelMapper.map(factureEntity, FactureDto.class);
    }

    @Override
    public FactureDto save(FactureDto factureDto) {

        if(factureDto.getRef() == null) return null;

        FactureEntity factureEntity = modelMapper.map(factureDto,FactureEntity.class);
        FactureEntity saved = factureDAO.save(factureEntity);
        return modelMapper.map(saved, FactureDto.class);
    }

    @Override
    public FactureDto update(FactureDto factureDto, int id, String ref, Date date) {
        Optional<FactureEntity> optionalFacture = factureDAO.findById(id);

        if(optionalFacture.isPresent()) {
        FactureEntity factureEntity = modelMapper.map(factureDto, FactureEntity.class);
        factureEntity.setId(id);
        factureEntity.setDate(date);
        factureEntity.setRef(ref);
        FactureEntity updated = factureDAO.save(factureEntity);
        return modelMapper.map(updated, FactureDto.class);
        } else {
            return null;// <-- aprés on va faire l'exception ici
        }

    }

    @Override
    public List<FactureDto> findAll(FactureDto factureDto) {
        return factureDAO.findAll().stream()
                .map(el -> modelMapper.map(factureDAO, FactureDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        factureDAO.deleteById(id);
    }
}

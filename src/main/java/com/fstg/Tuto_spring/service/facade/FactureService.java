package com.fstg.Tuto_spring.service.facade;

import com.fstg.Tuto_spring.dto.FactureDto;
import java.util.Date;
import java.util.List;


public interface FactureService {

    public FactureDto findByRef (String ref);

    public FactureDto findByDate(Date date);

    public FactureDto save(FactureDto factureDto);

    public FactureDto update(FactureDto factureDto, int id, String ref, Date date);

    public List<FactureDto> findAll(FactureDto factureDto);

    public void delete(int id);

}
